package step3;

import java.util.Scanner;

public class RacingCarGame {
  private CarRepository carRepository;
  private int numberOfReps;

  public RacingCarGame() {
    this.carRepository = new CarRepository();
  }

  public void startRacing() {
    ResultView.printExecutionComment();
    for (int i = 0; i < this.numberOfReps; i++) {
      carRepository.moveAllCars();
      ResultView.printCurrentStatus(this.carRepository);
    }
  }

  public void getRepetitionReady() {
    final String MESSAGE_ASKING_REPS = "시도할 횟수는 몇 회 인가요?";
    this.numberOfReps = Integer.parseInt(InputView.getInput(MESSAGE_ASKING_REPS));
  }

  public void getCarsReady() {
    final String MESSAGE_ASKING_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    for (String name : InputView.getInput(MESSAGE_ASKING_CARS).split(",")) {
      this.carRepository.addCar(new Car(name));
    }
  }
}
