package racingcar.view;

import java.util.List;
import racingcar.domain.ScoreBoard;
import racingcar.domain.ScoreBoards;

public class ResultView {

  public static void showScores(List<ScoreBoards> scores) {
    scores.forEach(score -> showScore(score));
  }

  private static void showScore(ScoreBoards scores) {
    scores.getScoreBoards().forEach(score -> showResult(score));
    System.out.println();
  }

  private static void showResult(ScoreBoard scoreBoard) {
    String carName = scoreBoard.getName();
    int position = scoreBoard.getCarPosition();

    putResult(carName, position);
  }

  private static void putResult(String carName, int position) {
    final String PROCESS_BAR = "-";
    final String DELIMITER = " : ";

    StringBuilder result = new StringBuilder(carName);
    result.append(DELIMITER);
    for (int i = 0; i < position; i++) {
      result.append(PROCESS_BAR);
    }
    System.out.println(result);
  }

  public static void showWinners(List<String> winners) {

    String names = "";
    final String DELIMITER = ", ";

    for (String winner : winners) {
      names += winner;
      names += DELIMITER;
    }

    names = names.substring(0, names.lastIndexOf(DELIMITER));
    names += "가 최종 우승했습니다.";

    System.out.println(names);

  }

}
