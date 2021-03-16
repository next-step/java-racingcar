package step4.view;

import step4.model.Cars;
import step4.util.MsgConstants;
import step4.util.VariableConstants;

public class ResultView {

  public void preRunScript(Cars cars) {
    System.out.println(MsgConstants.RESULT_PRINT_PRE_RUN.getMessage());
    printResult(cars);
  }

  public void printResult(Cars cars) {
    StringBuilder stringBuilder = new StringBuilder();
    cars.getCars().forEach(c -> {
      stringBuilder.append(makeIndividualCarsScore(c.showCarName(), c.showCarLocation()));
      stringBuilder.append(VariableConstants.RESULT_VIEW_LINE.getValue());
    });
    System.out.println(stringBuilder.toString());
  }

  public void afterRunScript(String champs){
    StringBuilder stringBuilder = new StringBuilder();

  }

  public void error(String message) {
    System.err.println(message);
  }

  public String makeIndividualCarsScore(String name, int score) {
    StringBuilder scoreBuilder = new StringBuilder();
    scoreBuilder.append(name);
    scoreBuilder.append(VariableConstants.RESULT_VIEW_DELIMITTER.getValue());
    for (int i = 0; i < score; i++) {
      scoreBuilder.append(VariableConstants.RESULT_VIEW_SCORE_FIELD.getValue());
    }
    return scoreBuilder.toString();
  }

}