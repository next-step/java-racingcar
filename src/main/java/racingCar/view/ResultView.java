package racingCar.view;

import racingCar.domain.Cars;

public class ResultView {

  private static final String RESULT_INTRO = "실행결과";
  private static final String WINNER_SENTENCE = "가 최종 우승했습니다.";

  public static void printResultIntro() {
    System.out.println(RESULT_INTRO);
  }

  public static void printError(String errorMsg) {
    System.out.println(errorMsg);
  }

  public static void printWinners(Cars cars) {
    System.out.println(cars.getWinnerNames() + WINNER_SENTENCE);
  }

}
