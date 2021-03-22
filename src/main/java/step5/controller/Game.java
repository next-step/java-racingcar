package step5.controller;

import step5.model.Car;
import step5.model.CarFactory;
import step5.model.Cars;
import step5.strategy.CarMovingStrategy;
import step5.strategy.Strategy;
import step5.util.Strings;
import step5.view.ResultView;

import java.util.List;

public class Game {
  Cars cars;
  ResultView resultView;
  private final Strategy strategy;

  private final int MINIMUM_LOCATION = 1;


  private final String INPUT_ERROR_ATTEMPTS = "입력된 경주 횟수를 확인하세요.";

  public Game() {
    resultView = new ResultView();
    strategy = new CarMovingStrategy();
  }

  public void run(String carNames, int attempt) {
    init(carNames, attempt);
    runCycle(attempt);
    afterRun();
  }

  public void init(String carNames, int attempt) {
    Strings.isValidCarNames(carNames);
    checkAttempts(attempt);
    cars = CarFactory.makeCarsWithMinimumLocs(carNames, MINIMUM_LOCATION);
    resultView.preRunScript(cars);
  }

  private void runCycle(int attempt) {
    for (int i = 0; i < attempt; i++) {
      cars.runCycle(strategy);
      resultView.printResult(cars);
    }
  }

  private void afterRun() {
    List<Car> champions = cars.findWinners();
    resultView.afterRunScript(champions);
  }

  private void checkAttempts(int attempt) {
    if (attempt < 1) {
      throw new IllegalArgumentException(INPUT_ERROR_ATTEMPTS);
    }
  }
}