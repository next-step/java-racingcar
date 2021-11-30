package Racing.score;

import static org.assertj.core.api.Assertions.assertThat;

import Racing.stage.Stage;
import Racing.type.RacingNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

  @Test
  @DisplayName("Score를 RacingString로 표시할수 있습니다")
  void showDisplay() {
    // given
    Stage stage = new Stage();
    RacingNumber racingNumber = new RacingNumber(5);
    Score score = new Score(stage, racingNumber);
    // when
    RacingNumber distance = score.getDistance();
    // then
    assertThat(distance.parseInt()).isEqualTo(5);
  }

  @Test
  @DisplayName("Score의 Stage가 같은지 확인할수 있습니다")
  void isSameStage() {
    // given
    Stage stage = new Stage();
    RacingNumber racingNumber = new RacingNumber(5);
    Score score = new Score(stage, racingNumber);
    // when
    boolean isSameStage = score.isSameStage(stage);
    // then
    assertThat(isSameStage).isTrue();
  }
}