# 자동차 경주 게임

## Goals
초간단 자동차 경주 게임을 구현한다.

## Function Condition
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## Programming Condition
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 이 과정의 Code Style은 intellij idea Code Style. Java을 따른다.
    - intellij idea Code Style. Java을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다.
- else 예약어를 쓰지 않는다.
- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## Class and Function
- Class
    - Car : 자동차
        - move() : 자동차를 움직인다.
        - getDistance() : 거리를 반환한다.
    - CarFactory : 자동차 생성 공장
        - createCars(int count) : 해당 대수 만큼 차량을 생성한다.
    - RandomGenerator : 난수 생성기
        - generate() : 난수를 랜덤으로 생성한다.
    - Racing : 레이싱을 하기 위한 클래스 (main)
    - View
        - OutputView
            - println() : 빈 공백의 라인을 생성한다.
            - println(char c, int count) : char을 count만큼 입력한다.
        - InputView
            - input(String message) : scanner로 console 인풋을 받으며 받기 전 message를 출력한다.

- interface
    - Movable : 움직일 수 있는지 검증하는 기능을 제공하는 인터페이스
        - isMovable(int number) : 내부에 존재하는 조건과 입력 값을 토대로 움직일 수 있는지 검증
