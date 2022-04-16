package racingcar.ui;

import java.util.List;

public class OutputView {

  private OutputView() {
  }

  public static void printOutput(List<Integer> results) {
    results.forEach(position -> System.out.println("-".repeat(position)));
    System.out.println();
  }
}
