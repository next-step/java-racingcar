# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 3단계 - 자동차 경주

### 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* else 예약어를 쓰지 않는다.
* 객체지향 생활 체조 원칙 지키기
* indent depth 2를 넘지 않는다.
* 함수의 길이는 15라인을 넘어가지 않는다.

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
   * 자동차에 이름을 부여할 수 있다.
   * interface.RacingGameInputView
      * int getTime(): comment 출력 후 게임 횟수를 입력받고 반환
      * List<CarName> getCarList(): comment 출력 후 Car 이름을 입력받고 반환
   * class.ConsoleRacingGameInputView
      * RacingGameInputView 구현체
4. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
   * interface.RacingGameResultView
      * void print(Car): 자동차의 이름과 position을 출력
   * class.ConsoleRacingGameResultView
      * RacingGameResultView 구현체
5. 모든 Round가 끝나면 우승자를 발표한다.
   * interface.RacingGameResultView
      * void announceWinner(List<CarName>): 우승한 자동차를 출력
