## 📚 목차

1. [🧠 프로젝트 주제 선정 이유 및 차별점](#-프로젝트-주제-선정-이유-및-차별점)
2. [⚙️ 개발 환경 및 기술 스택](#-개발-환경-및-기술-스택)
3. [📁 패키지 구조 요약](#-패키지-구조-요약)
4. [📦 주요 기능 상세 분석](#-주요-기능-상세-분석)
5. [✅ 요구사항 정의서](#-요구사항-정의서)
6. [📝 요구사항 명세서](#-요구사항-명세서)
7. [🔐 비기능 요구사항 명세서](#-비기능-요구사항-명세서)
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

```bash
# 실행 예시
javac app/MainApplication.java
java app.MainApplication


## 📁 패키지 구조 요약

src/
├── card/ # 카드 정보 VO, DAO, Service
│ ├── CardVO.java
│ ├── CardDAO.java
│ ├── CardService.java
│ └── file/ # 카드 데이터 파일 저장소 (직렬화 기반)
│ └── ObjFileHashMapCardDAO.java
│
├── cart/ # 장바구니 관련 구조
│ ├── CartItemVO.java
│ ├── CartDAO.java
│ ├── CartService.java
│ └── CartServiceImpl.java
│
├── order/ # 주문 처리 DAO, VO, Service
│ ├── OrderVO.java
│ ├── OrderDAO.java
│ └── OrderService.java
│
├── user/ # 회원 정보 및 인증 로직
│ ├── Member.java
│ ├── MemberDAO.java
│ ├── MemberService.java
│ └── file/
│ └── ObjFileHashMapMemberDAO.java
│
├── admin/ # 관리자 서비스 및 인터페이스
│ ├── AdminService.java
│ └── DHAdminService.java
│
└── app/ # 실행 진입점(MainApplication)
└── MainApplication.java

markdown
복사
편집

- 각 패키지는 **도메인별 역할**로 명확히 분리
- `file/` 서브패키지는 `.obj` 직렬화 기반 DAO 저장소 모듈
- `app/` 패키지는 콘솔 실행 진입점 및 전체 흐름 제어 담당


