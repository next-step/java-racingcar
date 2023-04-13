package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingGameTest {

  private MoveStrategy alwaysMoveStrategy = () -> true;
  private MoveStrategy neverMoveStrategy = () -> false;
  private RacingGame racingGame;

  @Test
  void 움직이는_전력으로_게임하는_경우() {
    racingGame = new RacingGame("car1,car2,car3", alwaysMoveStrategy);
    CarGroup carGroup = racingGame.play();

    for (Car car : carGroup.getCars()) {
      assertThat(car.position()).isEqualTo(1);
    }
  }

  @Test
  void 움직이지_않는_전략으로_게임하는_경우(){
    racingGame = new RacingGame("car1,car2,car3", neverMoveStrategy);
    CarGroup carGroup = racingGame.play();

    for (Car car : carGroup.getCars()) {
      assertThat(car.position()).isEqualTo(0);
    }
  }

  @Test
  void 승리자_찾기() {
    racingGame = new RacingGame("car1,car2,car3", alwaysMoveStrategy);
    racingGame.play();

    String[] winners = racingGame.findWinners();

    assertThat(winners).hasSize(3);
    assertThat(winners[0]).isEqualTo("car1");
    assertThat(winners[1]).isEqualTo("car2");
    assertThat(winners[2]).isEqualTo("car3");
  }
}