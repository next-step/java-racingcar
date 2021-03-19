package racingCar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.Car;
import racingCar.domain.TryResult;

public class ResultView {

  private static final String COLON = " : ";
  private static final String RESULT_INTRO = "실행결과";
  private static final String WINNER_SENTENCE = "가 최종 우승했습니다.";

  public void printResultIntro() {
    System.out.println(RESULT_INTRO);
  }

  public void printEmptyLine() {
    System.out.println();
  }

  public void printError(String errorMsg) {
    System.out.println(errorMsg);
  }

  public void printWinners(List<Car> winners) {
    String winnerNames = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(","));
    System.out.println(winnerNames + WINNER_SENTENCE);
  }

  public void printTryResult(List<TryResult> tryResults) {
    for (TryResult tryResult : tryResults) {
      System.out.print(tryResult.getName() + COLON);
      System.out.println(tryResult.getHyphenDistance());
    }
    printEmptyLine();
  }

}
