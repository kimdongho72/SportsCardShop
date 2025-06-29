## 📚 목차

1. [🧠 프로젝트 주제 선정 이유 및 차별점](#-프로젝트-주제-선정-이유-및-차별점)  
2. [⚙️ 개발 환경 및 기술 스택](#-개발-환경-및-기술-스택)  
3. [📁 패키지 구조 요약](#-패키지-구조-요약)  
4. [✅ 요구사항 정의서](#-요구사항-정의서)  
5. [📝 요구사항 명세서](#-요구사항-명세서)  
6. [🔐 비기능 요구사항 명세서](#-비기능-요구사항-명세서)  
7. [📦 주요 기능 상세 분석](#-주요-기능-상세-분석)  
   - 7-1. [👤 사용자 기능](#-사용자-기능)  
   - 7-2. [🃏 카드 기능](#-카드-기능)  
   - 7-3. [🛒 장바구니 기능](#-장바구니-기능)  
   - 7-4. [📦 주문 기능](#-주문-기능)  
   - 7-5. [🛠 관리자 기능](#-관리자-기능)  
8. [🧬 클래스 다이어그램](#-클래스-다이어그램)  
   - 8-1. [🃏 카드 구조](#-카드-구조) 
   - 8-2. [📦 주문 구조](#-주문-구조)  
   - 8-3. [👤 회원 구조](#-회원-구조)  
   - 8-4. [🛒 장바구니 구조](#-장바구니-구조)  
   - 8-5. [🛠 관리자 서버 구조](#-관리자-서버-구조)  
10. [🎮 유스케이스 다이어그램](#-유스케이스-다이어그램)  
11. [🧪 작동 시나리오](#-작동-시나리오)  
12. [🎥 프로젝트 시연 영상](#-프로젝트-시연-영상)  
13. [💬 프로젝트 회고](#-프로젝트-회고)




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

### 📁 패키지 구조 요약
```text
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
```



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

[Uploading 제목 <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=5,IE=9" ><![endif]-->
<!DOCTYPE html>
<html>
<head>
<title>제목 없는 다이어그램.drawio.html</title>
<meta charset="utf-8"/>
</head>
<body>
<div class="mxgraph" style="max-width:100%;border:1px solid transparent;" data-mxgraph="{&quot;highlight&quot;:&quot;#0000ff&quot;,&quot;nav&quot;:true,&quot;resize&quot;:true,&quot;xml&quot;:&quot;&lt;mxfile host=\&quot;app.diagrams.net\&quot; agent=\&quot;Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36\&quot; version=\&quot;27.1.6\&quot;&gt;&lt;diagram name=\&quot;페이지-1\&quot; id=\&quot;zJZk5gce9Qe_7WkE_Gwe\&quot;&gt;&lt;mxGraphModel dx=\&quot;1426\&quot; dy=\&quot;1954\&quot; grid=\&quot;1\&quot; gridSize=\&quot;10\&quot; guides=\&quot;1\&quot; tooltips=\&quot;1\&quot; connect=\&quot;1\&quot; arrows=\&quot;1\&quot; fold=\&quot;1\&quot; page=\&quot;1\&quot; pageScale=\&quot;1\&quot; pageWidth=\&quot;827\&quot; pageHeight=\&quot;1169\&quot; math=\&quot;0\&quot; shadow=\&quot;0\&quot;&gt;&lt;root&gt;&lt;mxCell id=\&quot;0\&quot;/&gt;&lt;mxCell id=\&quot;1\&quot; parent=\&quot;0\&quot;/&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-11\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-2\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-10\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;240\&quot; y=\&quot;450\&quot; as=\&quot;targetPoint\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-86\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0;entryY=0.5;entryDx=0;entryDy=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-2\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-85\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-2\&quot; value=\&quot;회원&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;shape=umlActor;verticalLabelPosition=bottom;verticalAlign=top;html=1;outlineConnect=0;\&quot; vertex=\&quot;1\&quot; parent=\&quot;1\&quot;&gt;&lt;mxGeometry x=\&quot;40\&quot; y=\&quot;525\&quot; width=\&quot;30\&quot; height=\&quot;60\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-12\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0.5;entryY=0;entryDx=0;entryDy=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-3\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-10\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-28\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=1;entryY=0.5;entryDx=0;entryDy=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-3\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-19\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-3\&quot; value=\&quot;관리자&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;shape=umlActor;verticalLabelPosition=bottom;verticalAlign=top;html=1;outlineConnect=0;\&quot; vertex=\&quot;1\&quot; parent=\&quot;1\&quot;&gt;&lt;mxGeometry x=\&quot;790\&quot; y=\&quot;160\&quot; width=\&quot;30\&quot; height=\&quot;60\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-9\&quot; value=\&quot;\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-4\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-8\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-4\&quot; value=\&quot;비회원\&quot; style=\&quot;shape=umlActor;verticalLabelPosition=bottom;verticalAlign=top;html=1;outlineConnect=0;\&quot; vertex=\&quot;1\&quot; parent=\&quot;1\&quot;&gt;&lt;mxGeometry x=\&quot;40\&quot; y=\&quot;70\&quot; width=\&quot;30\&quot; height=\&quot;60\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; value=\&quot;Sports card shop\&quot; style=\&quot;swimlane;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;1\&quot;&gt;&lt;mxGeometry x=\&quot;110\&quot; y=\&quot;-10\&quot; width=\&quot;650\&quot; height=\&quot;740\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-8\&quot; value=\&quot;회원가입\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;40\&quot; y=\&quot;45\&quot; width=\&quot;110\&quot; height=\&quot;70\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-10\&quot; value=\&quot;로그인\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;220\&quot; y=\&quot;270\&quot; width=\&quot;110\&quot; height=\&quot;70\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-17\&quot; value=\&quot;카드 검색\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;20\&quot; y=\&quot;270\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-19\&quot; value=\&quot;회원관리\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;430\&quot; y=\&quot;50\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-38\&quot; value=\&quot;&amp;lt;div&amp;gt;include&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;endArrow=classic;html=1;rounded=0;entryX=0.027;entryY=0.6;entryDx=0;entryDy=0;entryPerimeter=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;0.2096\&quot; y=\&quot;4\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;140\&quot; y=\&quot;309\&quot; as=\&quot;sourcePoint\&quot;/&gt;&lt;mxPoint x=\&quot;212.97000000000003\&quot; y=\&quot;311\&quot; as=\&quot;targetPoint\&quot;/&gt;&lt;mxPoint as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-70\&quot; value=\&quot;\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-47\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-69\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-47\&quot; value=\&quot;카드 관리\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;470\&quot; y=\&quot;250\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-43\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;60\&quot; y=\&quot;340\&quot; as=\&quot;targetPoint\&quot;/&gt;&lt;mxPoint x=\&quot;-10\&quot; y=\&quot;565\&quot; as=\&quot;sourcePoint\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-58\&quot; value=\&quot;장바구니\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;50\&quot; y=\&quot;620\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-67\&quot; value=\&quot;\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-61\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-66\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-61\&quot; value=\&quot;장바구니 추가, 삭제\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;440\&quot; y=\&quot;620\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-64\&quot; value=\&quot;\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-63\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-19\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-63\&quot; value=\&quot;회원 목록 보기,&amp;lt;div&amp;gt;회원 강제 탈퇴&amp;lt;/div&amp;gt;\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;233.5\&quot; y=\&quot;50\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-68\&quot; value=\&quot;\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-66\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-58\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-66\&quot; value=\&quot;장바구니 목록&amp;amp;nbsp;&amp;lt;div&amp;gt;주문&amp;lt;/div&amp;gt;\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;250\&quot; y=\&quot;620\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-69\&quot; value=\&quot;카드 등록,&amp;lt;span style=&amp;quot;background-color: transparent; color: light-dark(rgb(0, 0, 0), rgb(255, 255, 255));&amp;quot;&amp;gt;삭제&amp;lt;/span&amp;gt;\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;470\&quot; y=\&quot;410\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-71\&quot; value=\&quot;&amp;lt;div&amp;gt;include&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;endArrow=classic;html=1;rounded=0;entryX=0;entryY=0.625;entryDx=0;entryDy=0;entryPerimeter=0;exitX=1;exitY=0.5;exitDx=0;exitDy=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-10\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-47\&quot;&gt;&lt;mxGeometry x=\&quot;0.2096\&quot; y=\&quot;4\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;390\&quot; y=\&quot;310\&quot; as=\&quot;sourcePoint\&quot;/&gt;&lt;mxPoint x=\&quot;473\&quot; y=\&quot;312.5\&quot; as=\&quot;targetPoint\&quot;/&gt;&lt;mxPoint as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-73\&quot; value=\&quot;\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-72\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-17\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-72\&quot; value=\&quot;카드 상세 검색&amp;lt;div&amp;gt;(키워드, 필터링)&amp;lt;/div&amp;gt;\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;10\&quot; y=\&quot;140\&quot; width=\&quot;100\&quot; height=\&quot;70\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-74\&quot; value=\&quot;카드 주문\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;80\&quot; y=\&quot;410\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-75\&quot; value=\&quot;&amp;lt;div&amp;gt;include&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;endArrow=classic;html=1;rounded=0;exitX=0;exitY=1;exitDx=0;exitDy=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-10\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-74\&quot;&gt;&lt;mxGeometry x=\&quot;0.2096\&quot; y=\&quot;4\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;230\&quot; y=\&quot;370\&quot; as=\&quot;sourcePoint\&quot;/&gt;&lt;mxPoint x=\&quot;333\&quot; y=\&quot;372.5\&quot; as=\&quot;targetPoint\&quot;/&gt;&lt;mxPoint as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-81\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-78\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;130\&quot; y=\&quot;290\&quot; as=\&quot;targetPoint\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-78\&quot; value=\&quot;전체,인기 카드&amp;lt;div&amp;gt;목록 보기&amp;lt;/div&amp;gt;\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;123.5\&quot; y=\&quot;140\&quot; width=\&quot;110\&quot; height=\&quot;70\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-84\&quot; value=\&quot;\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;\&quot; edge=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-83\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-74\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-83\&quot; value=\&quot;주문 목록 보기\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;340\&quot; y=\&quot;380\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-85\&quot; value=\&quot;회원 탈퇴\&quot; style=\&quot;ellipse;whiteSpace=wrap;html=1;\&quot; vertex=\&quot;1\&quot; parent=\&quot;iz_S5Qn7kO7vmnREL7NZ-7\&quot;&gt;&lt;mxGeometry x=\&quot;320\&quot; y=\&quot;520\&quot; width=\&quot;120\&quot; height=\&quot;80\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-44\&quot; value=\&quot;&amp;lt;div&amp;gt;include&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;endArrow=classic;html=1;rounded=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-19\&quot;&gt;&lt;mxGeometry x=\&quot;0.2096\&quot; y=\&quot;4\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;410\&quot; y=\&quot;260\&quot; as=\&quot;sourcePoint\&quot;/&gt;&lt;mxPoint x=\&quot;435\&quot; y=\&quot;230\&quot; as=\&quot;targetPoint\&quot;/&gt;&lt;mxPoint as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-51\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0.958;entryY=0.25;entryDx=0;entryDy=0;entryPerimeter=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-3\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-47\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-59\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0.417;entryY=0;entryDx=0;entryDy=0;entryPerimeter=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-2\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-58\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-76\&quot; value=\&quot;&amp;lt;div&amp;gt;include&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;endArrow=classic;html=1;rounded=0;exitX=0.364;exitY=1;exitDx=0;exitDy=0;exitPerimeter=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-10\&quot;&gt;&lt;mxGeometry x=\&quot;0.2096\&quot; y=\&quot;4\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;450\&quot; y=\&quot;360\&quot; as=\&quot;sourcePoint\&quot;/&gt;&lt;mxPoint x=\&quot;280\&quot; y=\&quot;600\&quot; as=\&quot;targetPoint\&quot;/&gt;&lt;mxPoint as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-82\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0.192;entryY=0.95;entryDx=0;entryDy=0;entryPerimeter=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-2\&quot; target=\&quot;iz_S5Qn7kO7vmnREL7NZ-74\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;iz_S5Qn7kO7vmnREL7NZ-87\&quot; value=\&quot;&amp;lt;div&amp;gt;include&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;endArrow=classic;html=1;rounded=0;exitX=0.691;exitY=1.029;exitDx=0;exitDy=0;exitPerimeter=0;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;iz_S5Qn7kO7vmnREL7NZ-10\&quot;&gt;&lt;mxGeometry x=\&quot;0.2096\&quot; y=\&quot;4\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;480\&quot; y=\&quot;355\&quot; as=\&quot;sourcePoint\&quot;/&gt;&lt;mxPoint x=\&quot;450\&quot; y=\&quot;510\&quot; as=\&quot;targetPoint\&quot;/&gt;&lt;mxPoint as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;/root&gt;&lt;/mxGraphModel&gt;&lt;/diagram&gt;&lt;/mxfile&gt;&quot;,&quot;toolbar&quot;:&quot;pages zoom layers lightbox&quot;,&quot;page&quot;:0}"></div>
<script type="text/javascript" src="https://app.diagrams.net/js/viewer-static.min.js"></script>
</body>
</html>
없는 다이어그램.drawio.html…]()




## 🎥 작동 시나리오

![작동시나리오_확대버전](./assets/작동시나리오_확대버전.png)







## 🎥 프로젝트 시연 영상

사용자 메뉴 시연

https://youtu.be/2g4OhmLJRCY

관리자 메뉴 시연

https://youtu.be/Me0mchQwEaE



## 💬 프로젝트 회고

### 🙋 직접 해보며 느낀 점

1. 기능 흐름 중심의 설계 감각 향상
단순한 기능 나열이 아니라, 사용자가 자연스럽게 흐를 수 있는 메뉴 구성이 중요하다는 점을 체감함.

2. 계층 분리의 실전 감각 습득
VO, DAO, Service의 구조 분리를 통해 클래스의 책임과 역할을 명확히 구분하는 연습이 되었음.

3. UX 고려한 콘솔 개발 경험
입력 예외 처리, 조건 피드백, 명확한 메시지 제공 등으로 콘솔 환경에서도 사용자 경험을 개선할 수 있음을 배움.

4. 기능 확장에 따른 테스트의 중요성 인식
기능이 많아질수록 예상치 못한 충돌이 발생하며, 시나리오 기반 테스트의 필요성을 강하게 느꼈음.

5. 구조화된 개발 결과의 만족감
직접 설계한 흐름이 유스케이스 다이어그램, 작동 시나리오로 시각화되면서,
논리적으로 구성된 프로젝트의 성취감을 체험함.



### 🧠 가장 어려웠던 부분

1. 메뉴 흐름 및 기능 설계

사용자, 판매자, 관리자 각각의 기능을 어떻게 나눌지 정하고
메뉴 흐름이 자연스럽게 이어지도록 구조화하는 데 시간이 걸림.

로그인 분기, 권한별 기능 제한 등 조건이 복잡해질수록 재설계가 잦았음.

2. 계층 구조 설계 및 연동

VO/DAO/Service 계층을 나누는 건 기본이지만,
객체 간 데이터 전달이 꼬이면서 의도치 않은 Null이나 흐름 오류가 자주 발생함.

3. 카드 필터링 조건 구현

브랜드, 연도, 가격대, 게임명 등 다양한 조건으로 필터링해야 했기 때문에
조건 조합이 많고 로직이 복잡해져서 예상보다 많은 시간이 소요됨.

특히 CardSearchCondition을 활용한 검색 로직과 UI 출력 간 정합성을 맞추는 데 어려움이 있었음.

4. 예외 처리와 사용자 메시지 설계

유저가 잘못된 입력을 했을 때 프로그램이 멈추지 않고
자연스럽게 안내하고 다시 입력받게 하는 UX 설계가 필요했음.

5. 기능별 테스트 반복

구조가 커질수록 일부 기능을 고치면 다른 기능이 깨지는 현상이 발생.

메뉴 흐름을 따라가며 시나리오 기반 수작업 테스트를 수십 번 반복함.
### 🚀 다음에 개선하고 싶은 부분

1. 중복 조건 분기의 함수화
카드 상태, 사용자 권한 체크 등 여러 기능에서 반복되는 조건문이 많았고,
이 로직들을 공통 유틸 함수나 Service 계층 내 헬퍼 메서드로 정리하면 좋겠다고 느꼈음.

2. 테스트 자동화 부재
현재는 대부분 콘솔에서 수동 테스트를 통해 검증했지만,
기능이 많아질수록 JUnit 등의 테스트 프레임워크를 통해 자동 검증을 고려해야 함.

3. UI/UX 출력 통일성 부족
각 메뉴에서 출력 형식(정렬, 공백, 안내 메시지 등)이 약간씩 다르기 때문에
사용자 관점에서 일관된 UI 메시지와 메뉴 선택 흐름이 아쉬웠음.


### ✅ 회고 총평

처음 개발에 도전하면서 시행착오도 많았고, 여러 부분에서 도움을 받았지만  
기능 하나하나를 직접 설계하고 구현하는 과정을 통해 객체지향적 사고와 사용자 흐름에 대한 이해를 높일 수 있었습니다.  
단순한 기능 구현을 넘어서 구조화된 프로그램을 만들어본 경험이었고,  
다음 프로젝트에서는 꼭 웹 기반으로 확장해보고 싶다는 목표도 생겼습니다.


