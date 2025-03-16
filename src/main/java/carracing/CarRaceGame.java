package carracing;

import java.util.Scanner;

public class CarRaceGame {

  private int carCount;
  private int tryCount;
  private Car[] carList;

  public void start() {
    receiveUserInput();
    setUp();
    play();
  }

  private void receiveUserInput() {
    InputView inputView = new InputView(new Scanner(System.in));
    this.carCount = inputView.receiveCarCount();
    this.tryCount = inputView.receiveTryCount();
  }

  private void setUp() {
    this.carList = createCars(carCount);
  }

  private Car[] createCars(int carCount) {
    Car[] carList = new Car[carCount];
    for (int i = 0; i < carCount; i++) {
      carList[i] = new Car();
    }
    return carList;
  }

  private void play() {
    System.out.println("\n실행 결과");
    printCarStatus();
    for (int i = 0; i < tryCount; i++) {
      moveCars();
      printCarStatus();
    }
  }

  private void moveCars() {
    for (Car car : this.carList) {
      car.move(RandomNumberGenerator.generate());
    }
  }

  private void printCarStatus() {
    for (Car car : this.carList) {
      ResultView.printCarStatus(car);
    }
    System.out.println();
  }
}
