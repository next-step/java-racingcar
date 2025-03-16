package racingcar.view;

import java.util.List;
import racingcar.RacingBoard;

public class ResultView {

  public static void printResult(List<RacingBoard> racingBoards) {
    System.out.println("실행 결과");

    racingBoards.stream()
        .flatMap(board -> board.getRecords().stream())
        .forEach(record -> {
          System.out.println("-".repeat(record));
        });
  }
}
