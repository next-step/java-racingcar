# 자동차 경주 게임
## 기능 목록
* Controller
    - RacingCarController
        + 게임 설정 기능 호출
            - a.이동 규칙 설정: 랜덤 규칙
            - b.사용자 입력 값 설정: 자동차의 수, 이동할 거리
        + 게임 시작 및 종료 기능 호출

* Domain
    - Car
        + 자동차(레이싱카)
        + 기능
            - 차랑명 등록
            - 자동차 이동
            - 자동차 이름 조회
            - 자동차 현재 위치 조회
    - Game
        + 레이싱카 게임
        + 기능
            - 게임 설정 값 세팅
            - 경주 차량 등록
            - 게임 시작
            - 게임 설정 값 조회
            - 경주 차량 목록 조회
            - 게임 결과 조회
    - GameResult
        + 게임 결과
        + 기능
            - 운행 종료 게임 등록
            - 라운드별 결과 등록
            - 게임 승자 조회
            - 마지막 라운드 조회
            - 선두 차량 위치 조회
            - 라운드 목록 조회
    - GameSet
        + 게임 설정
        + 기능
            - 필수 설정 값 등록(이동 규칙, 차량 등록, 이동 가능 수)
            - 설정 값 유효성 검사
            - 이동 규칙 조회
            - 등록 차량 조회
            - 이동 가능 수 조회

* rule.move
    - MoveStrategy(interface)
        + 이동 규칙
        + 기능
            - 이동 여부
    - RandomMove
        + 랜덤 이동 규칙
        + 기능
            - 4이상 10미만의 수가 나올 경우 이동
* view
    - GameInputView
        + 사용자 입력 화면
        + 기능
            - 차량 명칭 입력(복수)
            - 이동 가능 수 입력
            - 유효성 검사(차량 명칭, 이동 가능 수)
    - GameResultView
        + 게임 결과 화면
        + 기능
            - 라운드별 결과 출력
            - 우승자 출력