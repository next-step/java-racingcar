## step1 - 학습 테스트 실습

## step2 - 문자열 덧셈 계산기 구현

### 필요 기능
  - [x] 빈값 확인 : 빈값 0으로 처리
  - [x] 데이터 파싱 : 구분자, 숫자값 분리
  - [x] 숫자값 분리 : 구분자 기준으로 분리, custom, default
  - [x] 합계

## step3 - 자동차 경주

### 필요 기능
- UI 로직
  - 입력 View 
    - [x] 자동차 대수, 경기 수 등 입력 값을 받는다
  - 결과 View - 자동차 이동 상태
    - [x] 마지막에 각 경기별 자동차의 현재 상태를 출력한다, 어느 시점에서나 출력할 것인지에 대한 제약은 없다
- 메인 로직
  - 레이싱 게임 관리
    - [x] 입력 View로 부터 자동차 대수, 경기 회수를 전달 받는다.
    - [x] 전달 받은 자동차 대수 값으로 자동차를 생성한다.
    - [x] 전달 받은 경기 수 값으로 경기를 생성한다.
  - 자동차
    - [x] 전진/정지가 가능하다.
  - 경기
    - [x] 경기를 진행한다. 경기 진행시 경기 규칙을 기준으로 자동차가 이동한다
    - [x] 경기가 끝나면 경기 기록을 저장한다.
  - 경기 규칙
    - [x] 입력 받은 값이 4 이상인 경우에만 자동차는 이동 할 수 있다.
  - 경기 기록
    - [x] 자동차와 경기 당시의 이동거리를 저장한다
  - 정수 생성
    - [x] 0 ~ 9 랜덤값을 생성한다.
    - [x] 입력 받은 값으로 정수를 반환 한다.

### 이슈 사항
- [x] Random 값 때문에 테스트가 힘듬, 무슨 방식으로 처리?
  - interface로 변경하여 의존성 역전의 원리 사용