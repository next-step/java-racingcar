[1주차] 자동차 경주 게임
Step2. 초간단 자동차 경주 게임 구현
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다. switch/case 도 쓰지 않는다.

1. 사용자로 부터, 자동차 대수/ 시도 횟수를 입력받는다. (총 2번 입력받음)
    - 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - 0 을 입력 받았을시, 예외처리
2. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    1) 전진조건: 0 ~ 9 사이에서 random 값을 구한다.
    2) random 값이 4이상일 경우 전진한다.
    - 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.
3. 자동차의 상태를 화면에 출력한다.
    - 어느 시점에 출력할 것인지에 대한 제약은 없다