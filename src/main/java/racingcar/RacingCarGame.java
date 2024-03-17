package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Random;

public class RacingCarGame {
  private Cars cars;
  private int numberOfReps;

  private final Random random;

  public RacingCarGame(Random random) {
    this.cars = new Cars();
    this.random = random;
  }

  public void getRepetitionReady() {
    final String MESSAGE_ASKING_REPS = "시도할 횟수는 몇 회 인가요?";
    this.numberOfReps = Integer.parseInt(InputView.getInput(MESSAGE_ASKING_REPS));
  }

  public void getCarsReady() {
    final String MESSAGE_ASKING_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    for (String name : InputView.getInput(MESSAGE_ASKING_CARS).split(",")) {
      this.cars.addCar(new Car(name));
    }
  }

  public void startRacing() {
    ResultView.printExecutionComment();
    for (int i = 0; i < this.numberOfReps; i++) {

      cars.moveAllCars(createMoveConditions());
      ResultView.printCurrentStatus(this.cars);
    }
  }

  private int[] createMoveConditions() {
    final int[] moveConditions = new int[this.cars.size()];
    for (int i = 0; i < moveConditions.length; i++) {
      moveConditions[i] = random.nextInt(10);
    }

    return moveConditions;
  }

  public void displayResult() {
    ResultView.printWinners(this.cars.leadingCars());
  }
}
