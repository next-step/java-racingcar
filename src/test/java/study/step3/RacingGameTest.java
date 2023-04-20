package study.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.racingGame.Cars;
import study.domain.racingGame.GameBoard;
import study.domain.racingGame.RacingGame;

public class RacingGameTest {

  private RacingGame game;
  private Cars cars;

  @BeforeEach
  void setUp() {
    this.cars = new Cars(5);
    this.game = new RacingGame();
  }

  @DisplayName("자동차 게임 준비 없이 시작 에러 테스트")
  @Test
  public void notReadyGameStartErrorTest() {
    assertThatThrownBy(() -> this.game.race())
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("게임 준비가 되지 않았습니다.");
  }

  @DisplayName("자동차 게임 준비 > 시작 테스트")
  @Test
  public void readyGameStartTest() {
    this.game.ready(3, this.cars);
    do {
      this.game.race();
    } while (!this.game.isFinish());
    assertThat(this.game.isFinish()).isEqualTo(true);
  }

  @DisplayName("게임 기록 조회")
  @Test
  public void getGameResultTest() {
    this.game.ready(3, this.cars);
    assertThat(this.game.race()).isInstanceOf(GameBoard.class);
  }
}