package step4.controller;

import step4.model.CarFactory;
import step4.model.Cars;
import step4.util.MsgConstants;
import step4.util.Strings;
import step4.util.VariableConstants;
import step4.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class Game {
  Cars cars;
  ResultView resultView;
  private final int MINIMUM_LOCATION = 1;
  private final int MAXIMUM_LENGTH = 5;

  public Game() {
    resultView = new ResultView();
  }

  public boolean run(String carNames, int attempt){
    boolean initResult = init(carNames);
    if(!initResult) return false;

    runCycle(attempt);
    return afterRun();
  }

  public boolean init(String carNames) {
    boolean validCarNamesFlag = isValidCarNames(carNames);
    if (!validCarNamesFlag) {
      return false;
    }

    cars = CarFactory.makeCarsWithMinimumLocs(carNames, MINIMUM_LOCATION);
    resultView.preRunScript(cars);
    return true;
  }

  private boolean runCycle(int attempt){
    boolean validAttemptsFlag = checkAttempts(attempt);
    if(!validAttemptsFlag){
      return false;
    }
    for (int i = 0; i < attempt; i++) {
      cars.runCycle();
      resultView.printResult(cars);
    }
    return true;
  }

  private boolean afterRun(){
    List<String> champions = cars.calcChampions();
    resultView.afterRunScript(champions);
    return true;
  }

  private boolean checkAttempts(int attempt) {
    if (attempt >= 1) {
      return true;
    }

    resultView.error(MsgConstants.INPUT_ERROR_ATTEMPTS.getMessage());
    return false;
  }

  private boolean isValidCarNames(String carNames) {
    if (!Strings.checkNotNullOrNotEmpty(carNames)) {
      resultView.error(MsgConstants.INPUT_ERROR_CAR_FULL_NAMES.getMessage());
      return false;
    }

    return isValidFactorNames(carNames);
  }

  private boolean isValidFactorNames(String carNames){
    if (
            !Strings.checkFactorsNotEmpty(carNames, VariableConstants.VARIABLE_NAME_SPLIT.getValue()) ||
            !Strings.checkFactorsMaximumLength(carNames, VariableConstants.VARIABLE_NAME_SPLIT.getValue(), MAXIMUM_LENGTH)
    ) {
      resultView.error(MsgConstants.INPUT_ERROR_CAR_NAMES.getMessage());
      return false;
    }
    return true;
  }
}