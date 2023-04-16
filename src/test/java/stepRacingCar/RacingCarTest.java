package stepRacingCar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.car.RacingCar;
import racingCar.car.move.RacingCarMoveDirectionStrategy;
import racingCar.car.move.RacingCarMoveForward;
import racingCar.car.move.RacingCarMoveServiceLocator;
import racingCar.exception.InvalidRacingCarNameException;

public class RacingCarTest {

  private final String racingCarName = "car1";

  private RacingCarMoveServiceLocator racingCarMoveServiceLocator;

  @BeforeEach
  void setup() {
    List<RacingCarMoveDirectionStrategy> allowedMoveStrategies = List.of(new RacingCarMoveForward());
    racingCarMoveServiceLocator = new RacingCarMoveServiceLocator(allowedMoveStrategies);
  }

  @DisplayName("[RacingCar.class] 레이싱카는 4이상의 숫자에서 전진한다")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  public void 레이싱카는_4_이상에서_전진한다(int moveAck) {
    // given
    RacingCar racingCar = new RacingCar(racingCarName, racingCarMoveServiceLocator) {
      @Override
      protected int getRandomMoveAck() {
        return moveAck;
      }
    };

    // when
    racingCar.moveIfPossible();

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
    RacingCar racingCar = new RacingCar(racingCarName, racingCarMoveServiceLocator) {
      @Override
      protected int getRandomMoveAck() {
        return moveAck;
      }
    };

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
    Assertions.assertThatThrownBy(() -> new RacingCar(레이싱카_이름, racingCarMoveServiceLocator))
        .isInstanceOf(InvalidRacingCarNameException.class);
  }
}
