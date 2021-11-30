package Racing.score;

import static org.assertj.core.api.Assertions.assertThat;

import Racing.stage.Stage;
import Racing.type.RacingNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreListTest {

  @Test
  @DisplayName("ScoreList 에 Score를 추가할수 있습니다.")
  void addScore() {
    // given
    Stage stage = new Stage();
    Score score = new Score(stage, new RacingNumber(5));
    ScoreList scoreList = new ScoreList();
    // when
    scoreList.addScore(score);
    // then
    assertThat(scoreList.showDisplay().toString()).isNotEmpty();
  }

  @Test
  @DisplayName("ScoreList 에서 특정 stage의 Score를 받을수 있습니다")
  void getScore() {
    // given
    Stage stage = new Stage();
    Score score = new Score(stage);
    ScoreList scoreList = new ScoreList();
    // when
    scoreList.addScore(score);
    // then
    assertThat(scoreList.getScore(stage).getDistance()).isNotNull();
  }
}