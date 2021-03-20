package step4.controller;

import step4.model.CarFactory;
import step4.model.Cars;
import step4.util.Strings;
import step4.view.ResultView;

import java.util.List;

public class Game {
  Cars cars;
  ResultView resultView;

  private final int MINIMUM_LOCATION = 1;
  private final int MAXIMUM_LENGTH = 5;

  private final String INPUT_ERROR_ATTEMPTS = "입력된 경주 횟수를 확인하세요.";

  public Game() {
    resultView = new ResultView();
  }

  public void run(String carNames, int attempt) {
    init(carNames, attempt);
    runCycle(attempt);
    afterRun();
  }

  public void init(String carNames, int attempt) {
    Strings.isValidCarNames(carNames);
    Strings.isValidFactorNames(carNames, MAXIMUM_LENGTH);
    checkAttempts(attempt);
    cars = CarFactory.makeCarsWithMinimumLocs(carNames, MINIMUM_LOCATION);
    resultView.preRunScript(cars);
  }

  private void runCycle(int attempt) {
    for (int i = 0; i < attempt; i++) {
      cars.runCycle();
      resultView.printResult(cars);
    }
  }

  private void afterRun() {
    List<String> champions = cars.calcChampions();
    resultView.afterRunScript(champions);
  }

  private void checkAttempts(int attempt) {
    if (attempt < 1) {
      throw new IllegalArgumentException(INPUT_ERROR_ATTEMPTS);
    }
  }
}