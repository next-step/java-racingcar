package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static base.BaseMethodSource.CAR_CREATE_ARGUMENTS_NAME_AND_NUMBER_;
import static base.BaseMethodSource.RANDOM_NUMBER_BELOW_10;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

  @ParameterizedTest
  @MethodSource(CAR_CREATE_ARGUMENTS_NAME_AND_NUMBER_)
  @DisplayName("자동차 객체를 생성할 경우 자동차의 초가 위치는 0으로 설정된다.")
  void create(String name, int carNumber) {
    // given

    // when
    RacingCar newCar = RacingCar.create(name, carNumber);

    // then
    assertThat(newCar)
            .hasFieldOrPropertyWithValue("name", name)
            .hasFieldOrPropertyWithValue("carNumber", carNumber)
            .hasFieldOrPropertyWithValue("position", 0);
  }

  @ParameterizedTest
  @MethodSource(RANDOM_NUMBER_BELOW_10)
  @DisplayName("자동차 clone할 경우 깊은 복사로 해쉬코드가 다른 새로운 객체가 생성된다.")
  void clone(int carNumber) {
    // given
    RacingCar newCar = RacingCar.create(carNumber);

    // when
    RacingCar copiedCar = newCar.clone();

    // then
    assertThat(System.identityHashCode(copiedCar))
            .isNotEqualTo(System.identityHashCode(newCar));
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

  @ParameterizedTest
  @CsvSource(value = { "schumacher,true", "gmoon,false" })
  @DisplayName("RacingCar equals 재정의, 동등성 비교")
  void equals(String name, boolean expected) {
    // given
    RacingCar newCar = RacingCar.create(name, 0);

    // when
    boolean isSameCar = RacingCar.create("schumacher", 0)
            .equals(newCar);

    // then
    assertThat(isSameCar)
            .isEqualTo(expected);
  }


}