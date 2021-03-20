package step4.view;

import step4.model.Cars;

import java.util.List;

public class ResultView {

  private static final String VARIABLE_NAME_SPLIT = ",";
  private static final String RESULT_VIEW_DELIMITTER = " : ";
  private static final String RESULT_VIEW_LINE = "\n";
  private static final String RESULT_VIEW_SCORE_FIELD = "-";
  private static final String RESULT_PRINT_PRE_RUN = "실행 결과";
  private static final String RESULT_PRINT_AFTER_RUN = "가 최종 우승했습니다.";
  private static final String RESULT_PRINT_AFTER_RUN_NO_CHAMPS = "우승한 사람이 없습니다.";



  public void preRunScript(Cars cars) {
    System.out.println(RESULT_PRINT_PRE_RUN);
    printResult(cars);
  }

  public void printResult(Cars cars) {
    StringBuilder stringBuilder = new StringBuilder();
    cars.getCars().forEach(c -> {
      stringBuilder.append(makeIndividualCarsScore(c.showCarName(), c.showCarLocation()));
      stringBuilder.append(RESULT_VIEW_LINE);
    });
    System.out.println(stringBuilder.toString());
  }

  public void afterRunScript(List<String> champs){
    StringBuilder stringBuilder = new StringBuilder();
    if(champs.size()==0) {
      System.out.println(RESULT_PRINT_AFTER_RUN_NO_CHAMPS);
      return;
    }
    for(int i=0; i<champs.size()-1; i++){
      stringBuilder.append(champs.get(i)).append(VARIABLE_NAME_SPLIT).append(" ");
    }
    stringBuilder.append(champs.get(champs.size()-1));
    System.out.println(stringBuilder.toString() + RESULT_PRINT_AFTER_RUN);
  }

  public String makeIndividualCarsScore(String name, int score) {
    StringBuilder scoreBuilder = new StringBuilder();
    scoreBuilder.append(name);
    scoreBuilder.append(RESULT_VIEW_DELIMITTER);
    for (int i = 0; i < score; i++) {
      scoreBuilder.append(RESULT_VIEW_SCORE_FIELD);
    }
    return scoreBuilder.toString();
  }

}