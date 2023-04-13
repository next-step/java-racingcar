package racingcar.ui;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

  private static final String RESULT_MESSAGE = "실행 결과";
  private static final String EMPTY = "";
  private static final String HYPHEN = "-";

  public void printResultAlert() {
    Printer.println(RESULT_MESSAGE);
  }

  public void printLocations(List<Integer> locationValues) {
    locationValues.stream()
        .map(value -> HYPHEN.repeat(value))
        .forEach(stringValue -> Printer.println(stringValue));

    Printer.println(EMPTY);
  }
}
