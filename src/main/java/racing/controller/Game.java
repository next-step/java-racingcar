package racing.controller;

import racing.model.CarFactory;
import racing.model.Cars;
import racing.view.ResultView;

public class Game {
  Cars cars;
  ResultView resultView;

  public Game() {
    resultView = new ResultView();
  }

  public boolean run(int carCount, int attempt) {
    boolean runnable = checkParameters(carCount, attempt);

    cars = makeCars(carCount);

    if (!runnable) {
      return false;
    }

    for (int i = 0; i < attempt; i++) {
      cars.runCycle();
      resultView.printResult(cars);
    }
    return true;
  }

  private boolean checkParameters(int carCount, int attempt) {
    if (carCount >= 1 && attempt >= 1) {
      return true;
    }

    resultView.error("입력 값에 오류가 있어 프로그램을 종료합니다.");
    return false;
  }

  private Cars makeCars(int carCount) {
    CarFactory carFactory = new CarFactory();
    return carFactory.makeCars(carCount);
  }
}