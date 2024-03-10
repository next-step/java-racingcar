package step3;

import java.util.Scanner;

public class RacingCarGame {
  private int numberOfCars;

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

  public void setNumberOfCars() {
    this.numberOfCars = InputView.getInputNumberOfCars();
  }

  public void setNumberOfReps() {
    this.numberOfReps = InputView.getInputNumberOfReps();
  }

  public int getNumberOfCars() {
    return this.numberOfCars;
  }

  public int getNumberOfReps() {
    return this.numberOfReps;
  }

  public void setCarsReady() {
    carRepository.addCars(this.numberOfCars);
  }
}
