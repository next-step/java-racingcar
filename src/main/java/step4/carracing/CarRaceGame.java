package step4.carracing;


import java.util.List;
import java.util.Scanner;

import static step4.carracing.ResultView.printCarStatus;

public class CarRaceGame {

  private final CarMoveStrategy carMoveStrategy;
  private final Scanner scanner;
  private List<String> carNames;
  private List<Car> carList;
  private int tryCount;

  public CarRaceGame(CarMoveStrategy carMoveStrategy, Scanner scanner) {
    this.carMoveStrategy = carMoveStrategy;
    this.scanner = scanner;
  }

  public void start() {
    receiveUserInput();
    setUp();
    play();
    judge();
  }

  private void receiveUserInput() {
    InputView inputView = new InputView(scanner);
    this.carNames = inputView.receiveCarNames();
    this.tryCount = inputView.receiveTryCount();
  }

  private void setUp() {
    this.carList = CarFactory.createCars(this.carNames);
  }

  private void play() {
    System.out.println("\n실행 결과");
    printCars();

    for (int i = 0; i < tryCount; i++) {
      moveCars();
      printCars();
    }
  }

  private void printCars() {
    for (Car car : this.carList) {
      printCarStatus(car);
    }
    System.out.println();
  }

  private void moveCars() {
    for (Car car: this.carList) {
      car.move(this.carMoveStrategy.getMoveSteps());
    }
  }

  private void judge() {
    List<Car> winners = CarRacingJudge.judgeWinners(this.carList);
    ResultView.printWinners(winners);
  }
}
