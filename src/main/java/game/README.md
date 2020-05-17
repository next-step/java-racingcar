# 3단계 - 자동차 경주

### 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* else 예약어를 쓰지 않는다.
* 객체지향 생활 체조 원칙 지키기

### 기능 구현 목록
1. 초간단 자동차 경주 게임을 구현한다.
   * 매회 게임마다 모든 자동차에게 1번씩 전진할 수 있는 기회를 준다.
   * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
   * class.RacingCar
      * int time, int numberOfCar
      * play(): 게임 진행
   * class.Car
      * int id, int position
      * void move(MovePolicy): MovePolicy interface 의 구현대로 position 값을 변경한다
2. 자동차가 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
   * class.RandomMovePolicy
      * random 값을 통해 전진,정지를 결정한다. MovePolicy 구현체
   * 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.
3. 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
   * interface.InputView
      * int setup(Comment): comment 출력 후 입력받은 변수를 반환
   * class.FileReaderInputView
      * InputView 구현체
      * InputStream in = new FileInputStream("") 으로 System.in 을 대체
4. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
   * interface.ResultView
      * void print(int): 인자를 출력
   * class.ConsoleResultView
      * ResultView 구현체
