# 자동차 경주(racing car)

### 요구사항

1. 사용자는 자동차 대수를 입력할 수 있다.
    - [x]  자동차 대수를 입력받는다.
    - [x]  자동차 대수가 정수 형태가 아닌 경우 예외를 던진다.
    - [x]  자동차 대수가 0이하의 숫자인 경우 예외를 던진다.
2. 사용자는 시도 횟수를 입력할 수 있다.
    - [x]  시도 횟수를 입력받는다.
    - [x]  시도 횟수가 정수 형태가 아닌 경우 예외를 던진다.
    - [x]  시도 횟수가 0이하의 숫자인 경우 예외를 던진다.
3. 매 시도마다 각 자동차는 0에서 9사이의 난수를 받아, 전진하거나 전진하지 않는다.
    - [x]  0에서 9사이의 난수를 생성한다.
    - [x]  난수가 0이상 3이하인 경우, 자동차는 전진하지 않는다.
    - [x]  난수가 4이상 9이하인 경우, 자동차는 전진한다.
4. 사용자는 자동차 경주의 과정을 볼 수 있다.
    - [x]  자동차 경주의 과정을 출력한다.

<br>

---

### 설계
![image](https://github.com/next-step/java-racingcar/assets/49775540/79b2014b-4b69-429f-be85-664ad23488a8)

1. **RacingCarApplication**
    - **필드**
        - 없음
    - **메서드**
        - `void main()`
            - 사용자 입출력 관련한 구현체를 생성 및 주입한다.
            - 자동차 경주를 실행한다.


2. **RacingGame**
   > 자동차 경주 프로그램에서 컨트롤러 역할을 담당한다.
    - **필드**
        - `InputView inputView` : 사용자 입력 객체
        - `OutputView outputView` : 사용자 출력 객체
    - **메서드**
        - `void play()`
            - 사용자 입출력 관련 메서드를 호출한다.
            - 레이스 객체를 생성하고 실제 레이스를 진행한다.


3. **Car**
   > 자동차에 해당하는 도메인 객체이다.
    - **필드**
        - `int number` : 자동차 번호
        - `int position` : 자동차 현재 위치
        - 자동차 번호가 0이하의 수라면 IllegalArgumentException을 던진다.
    - **메서드**
        - `int number()` : 자동차 번호를 반환한다.
        - `int position()` : 자동차 위치를 반환한다.
        - `void moveForwardOrStop()` : 조건에 따라 자동차가 전진하거나 전진하지 않는다.
            - 조건수가 0~3이면 전진하지 않고 위치를 유지한다.
            - 조건수가 4~9이면 전진한다. (위치를 +1 한다.)
            - 조건수가 0 미만이거나 9 초과라면 IllegalArgumentException을 던진다.
        - `Car from()` : 자동차 번호를 받아 Car 객체를 생성하는 정적 팩토리 메서드이다.


4. **Race**
   > 경주에 해당하는 도메인 객체이다.
    - **필드**
        - `List<Car> cars` : 경주에 참여하는 자동차 객체 리스트
        - `int playingCount` : 시도 횟수
        - `List<RoundResult> roundResults` : 라운드 결과들의 모임 리스트
    - **메서드**
        - `void run()` : playingCount 수 만큼의 라운드를 진행한다.
        - `GameResult result()` : 경기 결과를 GameResult 객체로 변환하여 반환한다.
        - `Race setUp()` : 경주 객체를 초기화 및 생성한다.
            - 자동차 대수가 0이하면 IllegalArgumentException을 던진다.
            - 시도 횟수가 0이하면 IllegalArgumentException을 던진다.
            - 자동차 대수에 따라 Car 객체 리스트를 생성한다.
            - Race 객체를 생성하는 정적 팩토리 메서드이다.


5. **RandomNumberGenerator**
   > 자동차 전진 여부에 해당하는 난수를 생성한다.
    - **필드**
        - 없음
    - **메서드**
        - `int generateRandomNumberBetweenZeroAndNine()` : 0~9의 난수를 생성한다.


6. **vo**
    - CarResult : 자동차 1대의 번호와 위치를 가지는 DTO
    - RoundResult : 1개의 라운드의 모든 자동차들의 정보(= CarResult)를 가지는 DTO
    - GameResult : 게임 전체 라운드의 모든 정보(= RoundResult)를 가지는 DTO


7. **view**
    - InputView : 사용자 입력 인터페이스
        - 입력 받은 숫자가 정수 형태가 아니면 NumberFormatException을 던진다.
    - OutputView : 사용자 출력 인터페이스
    - ConsoleInputView : 콘솔 전용 입력 구현체
    - ConsoleOutputView : 콘솔 전용 출력 구현체

---

### 실행 결과
<img width="240" alt="image" src="https://github.com/next-step/java-racingcar/assets/49775540/9d448747-ad6f-483b-9f1e-bd9b412555f5">
