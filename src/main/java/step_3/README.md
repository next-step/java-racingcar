# 자동차 경주

* [Package Structure](#package-structure)
* [Goals](#goals)
    * [Basic Example](#basic-example)
    * [Step By Step](#step-by-step)
* [Usage](#usage)
    * [GameInitialized & Input Parameters](#gameinitialized--input-parameters)
    * [Racing Game](#racing-game)
    * [Result](#result)
    

Package Structure
------
```
- RacingGameManager.java    // 레이싱 게임 실행 Main 메서드
- RacingGame                // 레이싱 게임 구현 객체
- RacingResult              // 현재 레이싱 게임의 상태|진행상황
- GameInputResult           // 레이싱 게임 초기화 값
- GameInputView             // 레이싱 게임 초기화 Input Prompt
- GameResultView            // 레이싱 게임 출력 Prompt
```

Goals
------
- `자동차 대수`와 `시동할 회수`의 안내메세지를 출력하고, 입력받은 받을수 있다..
- 0 에서 9사이의 `random` 값을 구하고, 4이상일 경우 전진한다.
- 레이싱결과를 화면에 출력할 수 있다.

### Basic Example
```java
GameInputResult inputResult = new GameInputView.Builder()
        .enterCarsMessage("자동차 대수는 몇 대 인가요?")
        .executionCountMessage("시도할 회수는 몇 회 인가요?")
        .build()
        .initialized();

System.out.println("실행 결과");
GameResultView.printRacingGames(new RacingGame.Builder()
        .enterCars(inputResult.enterCars())
        .execution(inputResult.executionCount())
        .build()
        .startRacing());
```

### Step By Step
```java
RacingGame racingGame = new RacingGame.Builder()
        .enterCars(inputResult.enterCars())
        .execution(inputResult.executionCount())
        .build();

RacingResult currentLaps = racingGame.standby();
// System.out.println("On Your Mark");
GameResultView.printRacingResult(currentLaps.gameStatus());
// System.out.println("Start!!");
while (!currentLaps.complete()) {
    currentLaps = racingGame.run(currentLaps.gameStatus());
    GameResultView.printRacingResult(currentLaps.gameStatus());
    System.out.print("\n");
}
```

Usage
------

### GameInitialized & Input Parameters

**RacingGame.java** 는 **Builder** 를 이용해서 초기화 한다.
`enterCars` 와 `execution` 은 반드시 입력 받아야 정상적으로 게임을 수행할 수 있다.

```java
RacingGame racingGame = new RacingGame.Builder()
    .enterCars(3)           // enter Cars
    .execution(4)           // excution Laps
    .build();
```

**GameInputView.java** 는 콘솔에서 입력 받은 인자값을
**GameInputResult** 로 저장한다.

```java
GameInputResult inputResult = new GameInputView.Builder()
        .enterCarsMessage("자동차 대수는 몇 대 인가요?")
        .executionCountMessage("시도할 회수는 몇 회 인가요?")
        .build()
        .initialized();

// 자동차 대수는 몇 대 인가요?   -> 3
// 시도할 회수는 몇 회 인가요?   -> 5
// inputResult = {enterCars: 3, executionCount: 5}
```

### Racing Game

**RacingGame.java** 는 두가지 형태로 동작한다.

실행과 결과를 한번에 수행하는 `startRacing()`([basic exaple](#basic-example)) 과
입력받은 `executionCount` 에 도달할 때까지 순차적으로 회차단위의 결과를 반환하는 
`run()` 을 이용한 동작을 수행한다. 해당 동작은 [step by step](#step-by-step) 과 같이 동작한다.

게임의 결과는 **RacingResult** 로 저장된다.
**RacingResult** 는 각 회차의 주행 결과를 `carsOnCourse` 저장하고, 다음 회차의 진행 여부를 `complete` 에 저장한다.

모든 주행 회차의 결과는 `RacingGame.lapHistory` 에 저장되어 진다.

### Result

게임이 종료된 이후에 결과는 `GameResultView.java` 를 통해 명령행으로 출력이 가능하며, 
 진행한 게임 방식에 따라 출력 방법을 달리한다.

[basic exaple](#basic-example) 에서 사용된 방식의 게임 진행과 게임 결과의 출력 시점을 다르게 하고 싶다면,
**RacingGame.startRacing()** 또는 **RacingGame.finalRacingData()** 의 값을 이용하여, 
아래와 같이 수행 할 수 있다.

```java

List<RacingResult> racingResult = racingGame.finalRacingData();
GameResultView.printRacingGames(racingResult);

```

또는 [step by step](#step-by-step) 과 같이 `GameResultView.printRacingResult()` 를 이용하여, 진행중에 출력을 수행할 수도 있다.
