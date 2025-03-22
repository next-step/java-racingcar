package step4.carracing;

import step4.carracing.domain.Cars;

import java.util.List;
import java.util.Scanner;

import static step4.carracing.ResultView.printCarStatus;

public class CarRaceGame {
  private final Scanner scanner;
  private Cars cars;
  private int tryCount;

  public CarRaceGame(Scanner scanner) {
    this.scanner = scanner;
  }

  public void start() {
    setUp();
    play();
    judge();
  }

  private void setUp() {
    InputView inputView = new InputView(scanner);
    List<String> carNames = inputView.receiveCarNames();
    this.tryCount = inputView.receiveTryCount();
    this.cars = CarFactory.createCars(carNames, new RandomCarMoveStrategy());
  }

  private void play() {
    System.out.println("\n실행 결과");
    printCarStatus(cars);
    for (int i = 0; i < tryCount; i++) {
      cars.moveCars();
      printCarStatus(cars);
    }
  }

  private void judge() {
    Cars winners = CarRacingJudge.judgeWinners(cars);
    ResultView.printWinners(winners);
  }
}
