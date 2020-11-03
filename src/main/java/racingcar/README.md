# 자동차 경주 게임 (우승자)
## 기능 요구사항
* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    * RacingCar::go
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
    * Car::allowMove
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다
    * ResultView::viewAll
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    * ResultView::drawWithName
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
    * RacingInformation::carNames
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
    * GameHistoy::getWinner

## 힌트
- 값을 입력 받는 API는 Scanner를 이용한다.
- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
- indent가 2이상인 메소드의 경우 메소드를 분리하면 indent를 줄일 수 있다.
- else를 사용하지 않아 indent를 줄일 수 있다.
- 자동차 이름을 쉼표(,)를 기준으로 분리하려면 String 클래스의 split(",") 메소드를 활용한다.
    ```
    String[] names = inputName.split(",");
    ``` 
- 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다.
- 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.

## 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
* 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
* UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
* 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
* else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### racingcar 구조
```
src
├── main
│     └── java
│         └── racingcar
│             ├── Constant.java
│             ├── Main.java
│             ├── README.md
│             ├── car
│             │     ├── Car.java
│             │     └── RacingCar.java
│             ├── game
│             │     ├── GameHistory.java
│             │     ├── RacingGame.java
│             │     ├── RacingGameImpl.java
│             │     └── RacingInfomation.java
│             ├── strategy
│             │     ├── CarNameInputStrategy.java
│             │     ├── InputStrategy.java
│             │     ├── MoveStrategy.java
│             │     └── PrintMarkStrategy.java
│             └── view
│                 ├── InputView.java
│                 └── ResultView.java
└── test
    └── java
        ├── racingcar
        │     └── RacingCarTest.java
        ├── step1
        │     ├── SetTest.java
        │     └── StringTest.java
        └── step2
            ├── ComputationalInformation.java
            ├── Operator.java
            ├── StringCalculator.java
            └── StringCalculatorTest.java
```

## 궁금증
1. 새 요구사항에 대해서 자동차에 이름이 추가되는 요구사항의 경우 이를 RacingCar를 유지하며 NamedRacingCar를 만들어야하는지 고민이 되는데, 이럴 경우 새로운 클래스를 만드는게 맞나요 아니면 수정하는게 맞을까요?
2. 이름이 추가되며 IntupView와 ResultView가 바뀌면서 InputView의경우 전략패턴을 사용했는데, 여기서 전략을 이름이 아닌 다른 기존의 전략으로 바꾸게되면 게임클래스에도 영향을 주게 돠기에
기존의 전략을 DefaultInputStrategy로 만들어뒀다가 삭제했습니다. 1번의 질문과 이어지는데 이런 요구사항 변경이 있을때 기존 기능잉 다 유지되도록 하며 추가해야할까요 아니면 수정을 하는게 맞을까요? 

