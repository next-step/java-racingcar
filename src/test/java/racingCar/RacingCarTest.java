package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.car.RacingCar;
import racingCar.exception.InvalidRacingCarNameException;
import racingCar.domain.random.RandomMoveAckGenerator;
import racingCar.random.ForwardOnlyMoveAckGenerator;
import racingCar.random.HoldOnlyMoveAckGenerator;

public class RacingCarTest {

  private final String racingCarName = "car1";

  @DisplayName("[RacingCar.class] 레이싱카는 4이상의 숫자에서 전진한다")
  @Test
  public void 레이싱카는_4_이상에서_전진한다() {

    // given
    RacingCar racingCar = new RacingCar(racingCarName, new ForwardOnlyMoveAckGenerator());

    // when
    racingCar.moveIfPossible();

    // then
    Assertions.assertThat(racingCar)
        .extracting("position")
        .isEqualTo(1);
  }

  @DisplayName("[RacingCar.class] 레이싱카는 4 미만의 숫자에서는 전진하지 않는다")
  @Test
  public void 레이싱카는_4_미만의_수에서는_전진안한다() {
    // given
    RacingCar racingCar = new RacingCar(racingCarName, new HoldOnlyMoveAckGenerator());

    // when
    racingCar.moveIfPossible();

    // then
    Assertions.assertThat(racingCar)
        .extracting("position")
        .isEqualTo(0);
  }

  @DisplayName("[RacingCar.class] 레이싱카의 이름은 5글자를 초과할 수 없다.")
  @Test
  public void 레이싱카의_이름은_5글자_초과_불가능() {
    // given
    final String 레이싱카_이름 = "car123";

    // when & then
    Assertions.assertThatThrownBy(() -> new RacingCar(레이싱카_이름, new RandomMoveAckGenerator()))
        .isInstanceOf(InvalidRacingCarNameException.class);
  }
}
