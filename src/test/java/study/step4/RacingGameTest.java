package study.step4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.racingGame.CarNames;
import study.domain.racingGame.Cars;
import study.domain.racingGame.RacingGame;

public class RacingGameTest {

  private RacingGame game;
  private Cars cars;

  @BeforeEach
  void setUp() {
    this.cars = new Cars(5);
    this.game = new RacingGame();
  }

  @DisplayName("게임 우승자 차량 이름 조회 테스트")
  @Test
  public void getWinnersTest() {
    this.game.ready(3, this.cars);
    do {
      this.game.race();
    } while (!this.game.isFinish());
    assertThat(this.game.getWinnerNames()).isInstanceOf(CarNames.class);
  }
}
