package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRoundTest {

  private RacingCars racingCars;

  @BeforeEach
  void setUp() {
    racingCars = RacingCars.create(Arrays.asList(RacingCar.create("gmoon")));
  }

  @Test
  @DisplayName("자동차 경주에 필요한 경기 객체를 생성한다.")
  void create() {
    // given

    // when
    RacingRound newRound = RacingRound.createFinalRound(racingCars);

    // then
    assertThat(newRound).isNotNull();
  }


}