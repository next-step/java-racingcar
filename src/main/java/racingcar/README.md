### 기능 요구 사항

- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것 인지에 대한 제약은 없다.

car.movable?

### 시나리오

Race 는 차들과 경기정보를 가지고 경기를 하는 서비스이다.
Race 는 경기정보에서 입력한 횟수만큼 loop 를 돈다(경기를 진행한다 -> Race.Racing)
Race 가 진행되면 차들한테 메세지를 보낸다 movable 하니?

각각의 차는 차는 각자의 movable strategy 으로 갈지 정한다.

Result view 는 현재 차들을 관리하는 Cars 객체의 위치로

결과를 display 한다.

### Todo

Controller

- Main 함수 만들기(Race 로 경주 시작 해보자)

View

- InputView 자동차 대수, 시도할 횟수 입력 부분 만들기
- ResultView 시도할 횟수만큼 돌려서 현재 자동차들의 위치를 표시해주는 View 만들기

Domain

- Car 클래스 만들기 (상태 값 현재 위치)
- Cars (Car 들을 관리하는 클래스)
- RaceInfo Race 정보를 전달하는 객체 만들기

Service

- RACE 클래스 만들기
- RacingService

### Done

- Main 함수 만들기
  
- InputView 자동차 대수, 시도할 횟수 입력 부분 만들기

- Car 클래스 만들기 (상태 값 현재 위치)
- Cars (Car 들을 관리하는 클래스)
- RaceInfo Race 정보를 전달하는 객체 만들기