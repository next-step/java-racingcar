# 자동차 경주 게임
## 기능 요구사항
* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    * RacingCar::go
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    * InputView::execute
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
    * Car::allowMove
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다
    * ResultView::viewAll

## 힌트
- 값을 입력 받는 API는 Scanner를 이용한다.

## 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
* 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
* UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
* 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
* else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### step3 구조
```
src
├── main
│     └── java
│         └── step3
│             ├── Constant.java략 //프로젝트에서 사용되는 상수모음 클래
│             ├── Main.java
│             ├── README.md
│             ├── car
│             │     ├── Car.java
│             │     └── RacingCar.java
│             ├── game
│             │     ├── RacingGame.java
│             │     ├── RacingGameImpl.java
│             │     └── RacingInfomation.java
│             ├── strategy
│             │     ├── MoveStrategy.java //자동차 이동 전략 FunctionalInterface
│             │     └── PrintMarkStrategy.java //ResultView에서 사용하는 출력 전
│             └── view
│                 ├── InputView.java
│                 └── ResultView.java
└── test
    └── java
        ├── step1
        │     ├── SetTest.java
        │     └── StringTest.java
        ├── step2
        │     ├── StringCalculator.java
        │     └── StringCalculatorTest.java
        └── step3
            └── RacingCarTest.java
```

## 구현시 애로사항
1. Observer Pattern을 사용하며 각각의 Observer들이 동작을 함에 있어 각각 전진상황을 출력하는 것과 
상태만 저장후 ResultView에서 모아서 출력하는 것의 트레이드오프를 모르겠습니다.
2. Subject 클래스인 RacingGameImpl의 execute는 반환타입이 void로 없기에 테스트를 적용하기가 어려운데 이를 어떻게 타개해야할지 고민됩니다.
테스트를 위해 반환타입을 있게끔 구현하는게 맞을까요? 
3. 인터페이스가 너무 많다고 생각이 들지만 어떤건 클래스만 구현하고 어떤건 인터페이스로 API 정의하는게 구분할 수 없어서 최대한 쪼개며 인터페이스화 하였는데,
이게 맞는지 확신이 없습니다. 
4. 퍼포먼스상 stream 보다는 for문이 더 빠르다고 하는데, 고려해야할까요?
5. 자동차가 여러대라면 하나의 자동차를 하나의 쓰레드로 봐서 CompletableFuture를 사용하는것도 괜찮을까요?
