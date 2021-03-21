package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static base.BaseMethodSource.CAR_CREATE_ARGUMENTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

  @ParameterizedTest
  @MethodSource(CAR_CREATE_ARGUMENTS)
  @DisplayName("자동차 객체를 생성할 경우 자동차의 초가 위치는 0으로 설정된다.")
  void create(String name) {
    // given

    // when
    RacingCar newCar = RacingCar.create(name);

    // then
    assertThat(newCar)
            .hasFieldOrPropertyWithValue("name", name)
            .hasFieldOrPropertyWithValue("position", 0);
  }

  @ParameterizedTest
  @MethodSource(CAR_CREATE_ARGUMENTS)
  @DisplayName("자동차 clone할 경우 깊은 복사로 해쉬코드가 다른 새로운 객체가 생성된다.")
  void clone(String name) {
    // given
    RacingCar newCar = RacingCar.create(name);

    // when
    RacingCar copiedCar = newCar.clone();

    // then
    assertThat(System.identityHashCode(copiedCar))
            .isNotEqualTo(System.identityHashCode(newCar));
  }

  @ParameterizedTest
  @MethodSource(CAR_CREATE_ARGUMENTS)
  @DisplayName("자동차가 이동할 경우 position 값 증가된다.")
  void move(String name) {
    // given
    RacingCar newCar = RacingCar.create(name);

    // when
    newCar.move(() -> true);

    // then
    assertThat(newCar.position()).isEqualTo(1);
  }

  @ParameterizedTest
  @CsvSource(value = { "gmoon,true","pobi,false" })
  @DisplayName("RacingCar equals 재정의, 동등성 비교")
  void equals(String name, boolean expected) {
    // given
    RacingCar newCar = RacingCar.create(name);

    // when
    boolean isSameCar = RacingCar.create("gmoon")
            .equals(newCar);

    // then
    assertThat(isSameCar)
            .isEqualTo(expected);
  }

  @Test
  @DisplayName("자동차 생성 validation")
  void checkCarNameLengthExceed() {
    // given

    // when

    // then
    assertThatThrownBy(() -> RacingCar.create("schumacher"))
            .isInstanceOf(IllegalArgumentException.class);
  }
}