package racingcar.ui;

import java.util.List;
import racingcar.model.Position;

public class OutputView {

  private OutputView() {
  }

  public static void printOutputStatement() {
    System.out.println("실행 결과");
  }

  public static void printOutput(List<Position> results) {
    results.forEach(position -> System.out.println("-".repeat(position.getPosition())));
    System.out.println();
  }
}
