package racingcar.ui;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

  private static final String RESULT_MESSAGE = "실행 결과";
  private static final String EMPTY = "";
  private static final String HYPHEN = "-";

  public void printResultAlert() {
    Printer.println(RESULT_MESSAGE);
  }

  public void printLocations(List<String> locationValues) {
    StringBuilder sb = new StringBuilder();
    for (String value : locationValues) {
      sb.append(value).append("\n");
    }

    Printer.println(sb.toString());
  }

  public void printWinner(List<String> winnerName) {
    String nameBundle = winnerName.stream()
        .collect(Collectors.joining(", "));

    Printer.println(nameBundle + "가 최종 우승했습니다.");
  }
}
