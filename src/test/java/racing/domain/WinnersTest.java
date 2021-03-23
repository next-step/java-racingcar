package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

  private RacingRound round;

  @BeforeEach
  void setUp() {
    RacingCar gmoon = RacingCar.create("gmoon");
    RacingCar speed = RacingCar.create("speed");
    RacingCar guest = RacingCar.create("guest");
    RacingCar poo = RacingCar.create("poo");
    gmoon.move(() -> true);
    speed.move(() -> true);
    round = RacingRound.create(RacingCars.create(Arrays.asList(gmoon, speed, guest, poo)));
  }

  @Test
  @DisplayName("우승자 객체 생성")
  void create() {
    // given

    // when
    Winners winners = Winners.create(round.racingCars());

    // then
    assertThat(Arrays.asList(RacingCar.create("gmoon"), RacingCar.create("speed")))
            .containsAll(winners.getList());
  }

}