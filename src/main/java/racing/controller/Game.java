package racing.controller;

import racing.model.Car;
import racing.model.CarFactory;
import racing.view.ResultView;

import java.util.List;

public class Game {
  private final int carCount;
  private final int attempt;

  CarFactory carFactory;
  ResultView resultView;

  public Game(int carCount, int attempt) {
    this.carCount = carCount;
    this.attempt = attempt;

    carFactory = new CarFactory();
    resultView = new ResultView();
  }

  public boolean run() {
    boolean runnable = checkParameters();

    if (!runnable) {
      return false;
    }
    carFactory.init(carCount);

    for (int i = 0; i < attempt; i++) {
      List<Car> resultCars = carFactory.runCycle();
      resultView.printResult(resultCars);
    }
    return true;
  }

  private boolean checkParameters() {
    if (carCount >= 1 && attempt >= 1) {
      return true;
    }

    resultView.error("입력 값에 오류가 있어 프로그램을 종료합니다.");
    return false;
  }
}
