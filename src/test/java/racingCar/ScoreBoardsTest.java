package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.ScoreBoard;
import racingcar.domain.ScoreBoards;

public class ScoreBoardsTest {

  @Test
  @DisplayName("caPosition 값이 제일 크면 우승자")
  void findWinnerTest() {
    List<ScoreBoard> scoreBoardList = new ArrayList<>();
    scoreBoardList.add(new ScoreBoard("son", 4));
    scoreBoardList.add(new ScoreBoard("cha", 3));
    scoreBoardList.add(new ScoreBoard("park", 2));
    ScoreBoards scoreBoards = new ScoreBoards(scoreBoardList);
    assertThat(scoreBoards.findFirst().get(0)).isEqualTo("son");
  }
}
