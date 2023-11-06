## 기능 요구사항
- [X] 초간단 자동차 경주 게임을 구현한다.
- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [X] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [X] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [X] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 프로그래밍 요구사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    -  UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 이 과정의 Code Style은 intellij idea Code Style. Java을 따른다.
    - intellij idea Code Style. Java을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
      e- lse를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 분석한 비즈니스 요구사항
- Controller
    - RacingGameRunner
        - [X] 주어진 횟수 동안 랜덤값을 구하여 자동차가 전진 혹은 멈출 수 있다.
- Domain
    - RandomPicker
        - [X] 랜덤으로 0 ~ 9 값을 구할 수 있다.
    - Car
        - [X] 자동차는 게임 진행 후, 움직일 수 있다.
            - [X] 자동차는 랜덤값이 4이상인 경우, 전진할 수 있다.
            - [X] 랜덤값이 4미만인 경우, 자동차는 움직이지 않는다.
- View
    - InputView
        - [X] 사용자로부터 자동차 수와 자동차 이동 횟수를 입력받을 수 있다.
    - ResultView
        - [X] 결과를 출력할 수 있다.
