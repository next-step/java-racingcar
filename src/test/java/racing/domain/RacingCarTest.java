package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static base.BaseMethodSource.RANDOM_NUMBER_BELOW_10;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

  @ParameterizedTest
  @MethodSource(RANDOM_NUMBER_BELOW_10)
  @DisplayName("자동차 객체를 생성할 경우 자동차의 초가 위치는 0으로 설정된다.")
  void create(int carNumber) {
    // given

    // when
    RacingCar newCar = RacingCar.create(carNumber);

    // then
    assertThat(newCar.position())
            .isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource(RANDOM_NUMBER_BELOW_10)
  @DisplayName("자동차 copyFrom할 경우 해쉬코드가 다른 새로운 객체가 생성된다.")
  void copyFrom(int carNumber) {
    // given
    RacingCar newCar = RacingCar.create(carNumber);

    // when
    RacingCar copiedCar = RacingCar.copyFrom(newCar);

    // then
    assertThat(copiedCar.hashCode())
            .isNotEqualTo(newCar.hashCode());
  }

  @ParameterizedTest
  @MethodSource(RANDOM_NUMBER_BELOW_10)
  @DisplayName("자동차가 이동할 경우 position 값 증가된다.")
  void move(int carNumber) {
    // given
    RacingCar newCar = RacingCar.create(carNumber);

    // when
    newCar.move(() -> true);

    // then
    assertThat(newCar.position()).isEqualTo(1);
  }
}