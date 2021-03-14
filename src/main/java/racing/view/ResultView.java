package racing.view;

import racing.model.Cars;

public class ResultView {
  private static final char LINE = '\n';
  private static final char SCORE_FIELD = '-';

  public void printResult(Cars cars) {
    StringBuilder stringBuilder = new StringBuilder();
    cars.getCars().forEach(c -> {
      stringBuilder.append(makeIndividualCarsScore(c.showCarLocation()));
      stringBuilder.append(LINE);
    });
    System.out.println(stringBuilder.toString());
  }

  public void error(String message) {
    System.out.println(message);
  }

  public String makeIndividualCarsScore(int score) {
    StringBuilder scoreBuilder = new StringBuilder();
    for (int i = 0; i < score; i++) {
      scoreBuilder.append(SCORE_FIELD);
    }
    return scoreBuilder.toString();
  }

}