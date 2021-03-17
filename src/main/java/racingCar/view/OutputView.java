package racingCar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.Car;

public class OutputView {

  private static final String RESULT = "실행결과";
  private static final String HYPHEN = "-";
  private static final String COLON = " : ";
  private static final String WINNER_SENTENCE = "가 최종 우승했습니다.";

  public void printResult() {
    System.out.println(RESULT);
  }

  public void printCarDistance(Car car) {
    System.out.print(car.getName() + COLON);
    for (int i = 0; i < car.getPosition(); i++) {
      System.out.print(HYPHEN);
    }
    printEmptyLine();
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
}
