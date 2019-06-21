package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Winners;

public class ResultView {

  public static final String POSITION_INDICATOR = "-";
  public static final String POSITION_PRINT_FORMAT = "%s : %s";
  public static final String WINNER_PRINT_FORMAT = "%s 가 최종 우승했습니다.";
  public final static String WINNERS_DELIMITER = ",";

  public static void displayRecord(List<Car> record) {
    record.stream().forEach(car -> printCarRecord(car));
    printBlankLine();
  }

  private static void printCarRecord(Car car) {
    String viewPosition = positionToIndicator(car.getPosition());
    String printFormat = makePrintFormat(car.getName(), viewPosition);
    System.out.println(printFormat);
  }

  private static String makePrintFormat(String name, String viewPosition) {
    return String.format(POSITION_PRINT_FORMAT, name, viewPosition);
  }

  private static String positionToIndicator(int position) {
    String positionView = "";
    for (int i = 0; i < position; i++) {
      positionView += POSITION_INDICATOR;
    }
    return positionView;
  }

  private static void printBlankLine() {
    System.out.println();
  }

  public static void displayWinnersOneLine(Winners winners) {

    System.out.printf(WINNER_PRINT_FORMAT, makeWinnersNameOneLine(winners.getNames()));
  }

  private static String makeWinnersNameOneLine(List<String> names) {
    return names.stream()
        .collect(Collectors.joining(WINNERS_DELIMITER));
  }

}
