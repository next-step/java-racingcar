package Racing.score;

import static org.assertj.core.api.Assertions.assertThat;

import Racing.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreListTest {

  @Test
  @DisplayName("ScoreList 에 Score를 추가할수 있습니다.")
  void addScore() {
    // given
    Stage stage = new Stage();
    ScoreList scoreList = new ScoreList();
    // when
    scoreList.addScore(stage);
    // then
    assertThat(scoreList.showDisplay().toString()).isNotEmpty();
  }

  @Test
  @DisplayName("ScoreList 에서 특정 stage의 Score를 받을수 있습니다")
  void getScore() {
    // given
    Stage stage = new Stage();
    ScoreList scoreList = new ScoreList();
    // when
    scoreList.addScore(stage);
    // then
    assertThat(scoreList.getScore(stage).showDisplay()).isNotNull();
  }
}