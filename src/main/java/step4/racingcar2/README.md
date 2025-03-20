# 🚀 3단계 - 자동차 경주(우승자) [CODE]

* `Controller` 가 `Model` 을 제어하고 `View` 를 통해 결과를 출력한다.
* `RacingCarGameController` 는 `main` 메소드를 가지고 있다.
* `RacingCarGameController` 는 `numberOfCars` 와 `numberOfRounds` 를 입력받는다.
* 입력받은 해당 값들로 `RacingCarGameSet` 을 생성한다.
* `RacingCarGameSet` 은 `RacingCarGameRound` 를 생성하고 `numberOfRounds` 만큼 반복하며 각 라운드 진행하고 그 결과를 보여준다.
* `RacingCarController` 는 `RacingCar` 를 제어하고 `RacingCarEngine` 를 통해 GO/STOP 이 결정된다.

* `RacingCarGame` 은 `RacingCarGameSet` 로 이루어져있다.
* `RacingCarGameSet` 는 `RacingCarGameRound` 로 이루어져있다.
* `RacingCarGameRound` 에는 해당 라운드를 진행할 `RacingCar[]` 가 있다.
* `RacingCar` 는 GO/STOP 을 결정하는 `RacingCarEngine` 을 가지고 있다.
