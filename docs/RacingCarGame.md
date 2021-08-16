# 자동차 경주 게임

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 실행 결과
위 요구 사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자: pobi, jun
```

## 프로그래밍 요구 사항
step1
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) 을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.

step2
- 핵심 비즈니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
- MVC 패턴 기반으로 리팩터링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.

## Racing Car Game 구현 기능 목록
- [x] 사용자로부터 자동차 경주에 참가하는 자동차들의 이름을 문자열로 입력받는다.
- [x] 사용자로부터 게임을 시도할 횟수를 입력받는다.
- [x] 게임을 시도할 횟수로 음수를 입력할 경우 IllegalArgumentException을 발생시킨다.
- [x] 쉼표(,)를 기준으로 자동차 이름을 구별하여 racingcargame.model.RacingCar 객체를 생성한다.
- [x] 자동차 이름은 5자를 초과할 수 없다.
- [x] 생성한 racingcargame.model.RacingCar 객체들을 racingCars 리스트에 저장한다.
- [x] 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 자동차는 전진한다.
- [x] 라운드마다 자동차들이 전진한 정도를 출력한다.
- [x] 전진한 정도(step)가 가장 높은 값을 구한다.
- [x] 그 값에 해당하는 자동차의 이름(name)들을 출력한다.

### RandomNumber 의 기능
- (Random) random
- `RandomNumber#createRandomNumber` : 1부터 10 사이의 랜덤한 숫자 생성

### RacingCar 의 기능
- MOVING_CONDITION : 레이싱카 이동조건
- MAX_LENGTH_OF_NAME : 레이싱카 이름 최대길이
- (String) name
- (int) step
- `RacingCar#RacingCar` : 생성자
- `RacingCar#checkCarNameLength` : 자동차이름길이 확인
- `RacingCar#move` : 전진
- `RacingCar#isWinner` : 우승 여부
- `RacingCar#getName` : getter
- `RacingCar#getStep` : getter

### RacingCars 의 기능
- BAR
- (List<RacingCar>) cars
- (RacingCarHistory) history
- `RacingCars#RacingCars` : 생성자
- `RacingCars#playGame` : 게임 시작
- `RacingCars#playRound` : 라운드 시작
- `RacingCars#stackUpBars` : 자동차 이동한 정도 나타내기
- `RacingCars#findMaxScore` : 최고 점수 반환
- `RacingCars#findWinners` : 우승자 반환

### RacingCarHistory 의 기능
- (List<String>) history
- `RacingCarHistory#RacingCarHistory` : 생성자
- `RacingCarHistory#addHistory` : 실행 결과 한 줄씩 쌓기
- `RacingCarHistory#getHistory` : getter

### RacingCarGameInputView 의 기능
- (Scanner) scanner
- `RacingCarGameInputView#inputCarNames` : 자동차 이름 입력
- `RacingCarGameInputView#inputRoundNumber` : 횟수 입력
- `RacingCarGameInputView#checkRoundNumber` : 횟수 확인

### RacingCarGameOutputView 의 기능
- `RacingCarGameOutputView#outputGame` : 실행결과 출력
- `RacingCarGameOutputView#outputWinners` : 우승자 출력

### RacingCarGameController 의 기능
- SEPARATOR
- (RacingCarGameInputView) inputView
- (RacingCarGameOutputView) outputView
- (RacingCarHistory) racingCarHistory
- `RacingCarGameController#start` : 시작. 흐름 제어
- `RacingCarGameController#createRacingCars` : 입력받은 자동차이름으로 자동차들을 생성
- `RacingCarGameController#splitBySeparator` : 문자열을 구분자로 분리
- `RacingCarGameController#createRacingCarsWithCarNames` : 자동차이름들로 자동차들 생성
