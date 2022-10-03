package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoards {

  private List<ScoreBoard> scoreBoards;

  public ScoreBoards(List<ScoreBoard> scoreBoards) {
    this.scoreBoards = scoreBoards;
  }

  public List<ScoreBoard> getScoreBoards() {
    return scoreBoards;
  }

  public List<String> findFirst() {
    return this.scoreBoards.stream()
        .filter(scoreBoard -> scoreBoard.getCarPosition() == maxPosition())
        .map(scoreBoard -> scoreBoard.getName())
        .collect(Collectors.toList());
  }

  private int maxPosition() {
    return this.scoreBoards.stream()
        .mapToInt(scoreBoard -> scoreBoard.getCarPosition())
        .max()
        .orElse(0);
  }


}
