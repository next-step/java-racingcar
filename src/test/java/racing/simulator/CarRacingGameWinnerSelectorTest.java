package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.types.RacingCar;
import racing.types.RacingCarName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarRacingGameWinnerSelectorTest {

  @DisplayName("한명의 우승자가 있을 때 우승자를 요청하면 한명의 우승자를 가져온다.")
  @Test
  public void select_returnOneWinners() {
    RacingCar winnerRacingCar = new RacingCar(new RacingCarName("a"));

    List<RacingCar> input = List.of(
        winnerRacingCar,
        new RacingCar(new RacingCarName("b")),
        new RacingCar(new RacingCarName("c"))
    );

    CarRacingGameWinnerSelector selector = new CarRacingGameWinnerSelector();

    List<RacingCar> winners = selector.select(input);
    assertThat(winners).containsOnly(winnerRacingCar);
  }

  @DisplayName("여러명의 우승자가 있을 때 우승자를 요청하면 여러명의의 우승자를 가져온다.")
  @Test
  public void select_returnMultipleWinners() {
    RacingCar winnerRacingCar1 = new RacingCar(new RacingCarName("a"));
    RacingCar winnerRacingCar2 = new RacingCar(new RacingCarName("b"));

    List<RacingCar> input = List.of(
        winnerRacingCar1,
        winnerRacingCar2,
        new RacingCar(new RacingCarName("c"))
    );

    CarRacingGameWinnerSelector selector = new CarRacingGameWinnerSelector();

    List<RacingCar> winners = selector.select(input);
    assertThat(winners).containsOnly(winnerRacingCar1, winnerRacingCar2);
  }

}
