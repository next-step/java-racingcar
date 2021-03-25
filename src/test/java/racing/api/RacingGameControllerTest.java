package racing.api;

import org.junit.jupiter.api.Test;
import racing.domain.RacingCar;
import racing.domain.RacingCars;
import racing.domain.Winners;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

  @Test
  void winnerNameList() {
    // given
    // input
    String input = "gmoon, speed, move1, move2";

    // when
    RacingCar move1 = RacingCar.create("move1");
    RacingCar move2 = RacingCar.create("move2");
    move(move1);
    move(move2);
    List<RacingCar> racingCarList = Arrays.asList(move1
            , move2
            , RacingCar.create("gmoon")
            , RacingCar.create("speed"));

    List<String> winnerNames = Winners.create(RacingCars.create(racingCarList))
            .winnerNames();

    // then
    assertThat(winnerNames)
            .isNotEmpty()
            .hasSize(2)
            .containsAll(Arrays.asList("move1", "move2"));
  }

  private void move(RacingCar car) {
    car.move(() -> true);
  }
}