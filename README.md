
## 📚 목차

1. [🧠 프로젝트 주제 선정 이유 및 차별점](#-프로젝트-주제-선정-이유-및-차별점)  
2. [⚙️ 개발 환경 및 기술 스택](#-개발-환경-및-기술-스택)  
3. [📁 패키지 구조 요약](#-패키지-구조-요약)  
4. [✅ 요구사항 정의서](#-요구사항-정의서)  
5. [📝 요구사항 명세서](#-요구사항-명세서)  
6. [🔐 비기능 요구사항 명세서](#-비기능-요구사항-명세서)  
7. [📦 주요 기능 상세 분석](#-주요-기능-상세-분석)  
8. [🧬 클래스 다이어그램](#-클래스-다이어그램)  
9. [🎮 유스케이스 다이어그램](#-유스케이스-다이어그램)  
10. [🧪 작동 시나리오 및 테스트](#-작동-시나리오-및-테스트)  
11. [🎥 프로젝트 시연 영상](#-프로젝트-시연-영상)  
12. [💬 프로젝트 회고 및 배운 점](#-프로젝트-회고-및-배운-점)




## 🧠 프로젝트 주제 선정 이유 및 차별점

### 🎯 프로젝트 목적

- **실제 존재하는 수집 시장**을 기반으로 한 구조 설계 훈련  
- **VO / DAO / Service 계층 분리**를 통한 아키텍처 구현 능력 강화  
- 사용자 흐름, 관리자 통제, 조건 검색 등 **현실적인 시나리오 반영**

### 📈 스포츠 카드 시장 분석

- 글로벌 카드 거래 시장은 2022년 기준 약 1억 3,230만 달러  
- 2031년까지 약 4억 달러 규모 성장 전망  
- 투자, 수집, 커뮤니티 등 다양한 활용 분야 존재

### 🧍 사용자 페르소나 기반 기능 설계

| 이름 | 연령대 | 특징 및 니즈 |
|------|--------|---------------|
| 김OO (20대 수집가) | 빠른 키워드 검색, 간편 결제, 새 카드 정보에 민감 |
| 이OO (40대 투자자) | 등급 정보 중시, 카드 상세 스펙 중요, 장기 투자 관점 |

## ⚙️ 개발 환경 및 기술 스택

### 💻 개발 언어 및 환경

- **Language**: Java 17+
- **IDE**: Eclipse (또는 IntelliJ)
- **실행 방식**: CLI(Console) 기반


src/
├── card/                카드 정보 VO, DAO, Service
│   ├── CardVO.java
│   ├── CardDAO.java
│   ├── CardService.java
│   └── file/
│       └── ObjFileHashMapCardDAO.java
│
├── cart/                장바구니 관련 구조
│   ├── CartItemVO.java
│   ├── CartDAO.java
│   ├── CartService.java
│   └── CartServiceImpl.java
│
├── order/               주문 처리 DAO, VO, Service
│   ├── OrderVO.java
│   ├── OrderDAO.java
│   └── OrderService.java
│
├── user/                회원 정보 및 인증 로직
│   ├── Member.java
│   ├── MemberDAO.java
│   ├── MemberService.java
│   └── file/
│       └── ObjFileHashMapMemberDAO.java
│
├── admin/               관리자 서비스 및 인터페이스
│   ├── AdminService.java
│   └── DHAdminService.java
│
└── app/                 실행 진입점
    └── MainApplication.java



## ✅ 요구사항 정의서

![요구사항 정의서](https://github.com/user-attachments/assets/37574d2e-ec77-48e7-961e-82d22a55c5e0)


## 📝 요구사항 명세서

![요구사항명세서](https://github.com/user-attachments/assets/2a957fca-2b5e-4b56-8253-4b64e6531038)


## 🔐 비기능 요구사항 명세서

![비기능 요구사항 명세서](https://github.com/user-attachments/assets/0ba10dfb-293c-4f36-aeb0-6f14fac867f3)




## 📦 주요 기능 상세 분석

요구사항 정의서 기반으로, 전 기능을 간단하게 분류하여 정리합니다.  
각 기능은 실제 구현된 메서드 또는 서비스 호출 흐름을 기준으로 요약됩니다.

---

### 👤 사용자 기능

- **회원가입**: ID 중복 체크 후 가입 (`join()`)
- **로그인**: ID/PW 확인 후 역할 분기 (`login()`)
- **회원 정보 확인**: 로그인 후 내 정보 출력
- **비밀번호 변경**: 기존 PW 확인 후 수정 (`updateInfo()`)
- **회원 탈퇴**: 확인 후 회원 데이터 삭제 (`withdraw()`)

---

### 🃏 카드 기능

- **카드 등록**: 관리자만 등록 가능 (`registerCard()`)
- **전체 카드 목록 조회**: 모든 카드 조회 (`getAllCards()`)
- **카드 키워드 검색**: 이름, 팀, 카테고리 포함 문자열 검색 (`searchCards()`)
- **카드 필터 검색**: 가격, 브랜드, 연도, 등급 조건 검색
- **인기 카드 보기**: 좋아요/판매수 높은 순 정렬
- **카드 주문하기**: 재고 차감 후 주문 처리 (`placeOrder()`)

---

### 🛒 장바구니 기능

- **장바구니 보기**: 사용자별 담긴 카드 목록 출력
- **카드 추가**: 수량 지정 후 장바구니 담기 (`addToCart()`)
- **전체 주문**: 장바구니 전체 결제 처리 (`checkoutAll()`)
- **비우기**: 장바구니 초기화
- **특정 카드 삭제**: 선택 카드만 장바구니에서 제거

---

### 📦 주문 기능

- **내 주문 목록 보기**: 사용자 ID 기준으로 주문 내역 출력
- **전체 주문 목록 조회**: 관리자 전용 전체 내역 확인
- **주문 상태 변경**: 예약 중 → 거래 완료 (`updateOrderStatus()`)

---

### 🛠 관리자 기능

- **회원 강제 탈퇴**: ID 입력 시 강제 삭제 (`forceRemoveMember()`)
- **전체 회원 목록 조회**: 가입된 모든 회원 확인
- **카드 삭제**: 카드 ID 기반 삭제 처리 (`deleteCard()`)
- **카드 재고 수정**: 수량 입력 후 재고 변경 (`updateCardStock()`)




## 🧬 클래스 다이어그램

본 프로젝트의 주요 도메인 구조를 시각화한 클래스 다이어그램입니다.  
VO/DAO/Service 계층이 분리되어 있으며, 각 책임이 명확하게 정의되어 있습니다.

---

### 🃏 카드 구조

![KakaoTalk_20250625_031441225](https://github.com/user-attachments/assets/62e2b258-db9c-4cb0-9fce-1c4ddf79b2a2)


- 카드 정보를 담는 `CardVO`
- 카드 조회/검색/등록 등의 기능을 담당하는 DAO, Service 계층
- 관리자만 등록/삭제/재고 수정 가능

---

### 📦 주문 구조

![KakaoTalk_20250625_031711848](https://github.com/user-attachments/assets/b608ad01-71d1-423a-8b38-0571953bbfdb)


- 주문 상세 정보를 저장하는 `OrderVO`
- 주문 저장 및 조회를 담당하는 DAO
- 주문 생성 및 상태 변경 처리 로직은 Service 계층에서 수행

---

### 👤 회원 구조


![KakaoTalk_20250625_031426028](https://github.com/user-attachments/assets/a0f1861d-13f4-4ad3-9520-7b18294bcc02)

- 사용자 정보를 담는 `Member`
- 회원가입/로그인/수정/탈퇴 기능 분리
- 관리자 여부 확인 후 메뉴 분기 가능

---

### 🛒 장바구니 구조

![KakaoTalk_20250625_031426028_01](https://github.com/user-attachments/assets/b2d6e189-de40-469b-a82d-23a61f0d36b6)



- 사용자 ID별 장바구니 맵 관리
- `CartItemVO`로 구성된 리스트로 카드 ID, 수량 저장
- 전체 주문, 비우기, 개별 삭제 등 메서드로 제공

---

### 🛠 관리자 서버 구조

![KakaoTalk_20250625_031426028_02](https://github.com/user-attachments/assets/3eb44e32-225e-449e-a25c-e2c9b7083598)


- 관리자 전용 기능을 정의한 `AdminService` 인터페이스
- 카드/회원/주문 관련 기능을 통합 처리하는 `DHAdminService` 구현체


## . 유스케이스 다이어그램
곧 쓸 예정



## 🎥 작동 시나리오

![RPBFQkfG4CRtvobcgIltkhW-mTtVvOKRkOBLOj9zcgGqKXU21iK_8T8_nH8XnhIDqBxGcJdlq9FZGOAuSfpvvZlV_4ZJjFxshPkh3bC5OtKn7z9Yn1ERmhi6g-DwoJzpMkKDnjejgF3CnfUOmf5iIT6lAbZ_ZIvK_XXcbG7KJtF0pGG76T2hfvpaZ0uPZfU0unsk](https://github.com/user-attachments/assets/08789062-9c19-4fe8-bc64-8b3b099c5903)


## 🎥 프로젝트 시연 영상 ( 공개로 수정 해야됨)

사용자 메뉴 시연
https://youtu.be/2g4OhmLJRCY

관리자 메뉴 시연

https://youtu.be/Me0mchQwEaE



## 11. 프로젝트 회고

### 🙋 직접 해보며 느낀 점

- 실제 기능 구현 흐름을 따라가며 **서비스 분리**와 **유저/관리자 권한 구분**의 중요성을 체감했습니다.
- 단순히 동작만 하는 코드가 아닌, **확장성과 유지보수를 고려한 구조 설계**의 필요성을 배웠습니다.

### 🧠 가장 어려웠던 부분

- 카드 필터 검색, 장바구니 결제 로직 등 **복합 조건 처리**에 시간이 많이 소요되었습니다.
- 유스케이스, 클래스 다이어그램을 실제 코드 구조와 일치시키는 데 신경을 많이 썼습니다.

### 🚀 다음에 개선하고 싶은 부분

- 콘솔 기반에서 벗어나 GUI 또는 Web 기반으로 확장
- 로그인 유지 상태 기반의 사용자 세션 관리
- 테스트 자동화 및 JUnit 기반 테스트 케이스 도입

---


