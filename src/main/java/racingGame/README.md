# Step5 자동차 경주 리팩토링

## 구조 개요

1개의 진입점 클래스와 2개의 UIView 클래스, 2개의 메인 도메인 클래스, 1개의 interface 로 구성되어 있다.

테스트는 도메인 클래스만 수행한다.

모든 의존성은 진입점 클래스만 가지고 있다.

- 진입점 클래스
  - RacingGamePlayer
- UI 클래스
  - InputView
  - ResultView
- 도메인 클래스
  - RacingGame
  - Car
- 도메인 인터페이스
  - Engine
  
### Car 클래스 기능

#### 1. constructor

 - 레이서 이름과 엔진 인터페이스를 주입 받아 움직일 때마다 어떻게 움직일 지 초기화 한다.

#### 2. move

 - engine 인터페이스에서의 moveDistanceForOneTime 을 실행해 한번씩 움직인 후의 결과를 리턴한다.
 - 같은 도메인 객체인 RacingGame 에서만 활용 할 수 있게 default 로 뺀다.

#### 3. getDistance

  - 현재 까지 움직인 거리를 리턴한다

#### 4. getRacer

  - racer 이름을 리턴한다

### Engine 인터페이스

  - moveDistanceForOneTime() Car 가 move 할 때마다 한번씩 움직일 방법을 준다.
  - functional 이다.

### RacingGame 클래스 기능

#### 1. constructor

 - 초기화 된 Car 들을 입력 받아 초기화 한다.
 
#### 2. move()

 - 각 Car 들에게 move 를 전부 수행한 뒤 리턴한다.
 - Car 클래스에서의 변화를 요구하는 move()는 default 라서 방어적 복사는 필요없다.
 
#### 3. getWinner()

  - 현재 상태에서의 우승자를 리턴한다.