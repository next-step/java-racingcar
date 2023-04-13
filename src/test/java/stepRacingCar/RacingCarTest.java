package stepRacingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.car.RacingCar;

public class RacingCarTest {

  private final long racingCarId = 1;

  @DisplayName("[RacingCar.class] 레이싱카는 4이상의 숫자에서 전진한다")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  public void 레이싱카는_4_이상에서_전진한다(int moveAck) {
    // given
    RacingCar racingCar = new RacingCar(racingCarId);

    // when
    racingCar.moveIfPossible(moveAck);

    // then
    Assertions.assertThat(racingCar)
        .extracting("position")
        .isEqualTo(1);
  }

  @DisplayName("[RacingCar.class] 레이싱카는 4 미만의 숫자에서는 전진하지 않는다")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  public void 레이싱카는_4_미만의_수에서는_전진안한다(int moveAck) {
    // given
    RacingCar racingCar = new RacingCar(racingCarId);

    // when
    racingCar.moveIfPossible(moveAck);

    // then
    Assertions.assertThat(racingCar)
        .extracting("position")
        .isEqualTo(0);
  }
}
