package racingcar.ui;

import java.util.List;

public class ResultView {

  private static final String RESULT_MESSAGE = "실행 결과";

  public void printResult() {
    Printer.print(RESULT_MESSAGE);
  }

  public void printLocations(List<Integer> locationValues) {
    locationValues.stream()
        .map(value -> value.toString())
        .forEach(stringValue -> Printer.print(stringValue));
  }
}
