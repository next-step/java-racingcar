package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.step4.domain.Cars;
import racingcar.step4.domain.factory.CarFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.step4.domain.CarName.*;
import static racingcar.step4.domain.factory.CarFactory.NAME_SEPARATOR;

@DisplayName("자동자 생성 테스트")
public class CarFactoryTest {
  @ParameterizedTest
  @CsvSource(value = {"pobi:1", "pobi,crong:2", "pobi,crong,honux:3"}, delimiter = ':')
  @DisplayName("자동차 이름 쉼표(,) 기준으로 들어올 경우, 정상적으로 자동차 n대 생성되는지 테스트")
  void carCreateTest(String given, int expected) {
    assertThat(CarFactory.of(given).getCars()).hasSize(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"pobi", "pobi,crong", "pobi,crong,honux"}, delimiter = ':')
  @DisplayName("자동차 생성 후, 자동차 이름 확인 테스트")
  void carCreateTest2(String given) {
    Cars cars = CarFactory.of(given);
    String[] names = given.split(NAME_SEPARATOR);

    for (int i = 0; i < names.length; i++) {
      assertThat(cars.getCars().get(i).getCarName().get()).isEqualTo(names[i]);
    }
  }

  @Test
  @DisplayName("자동차 이름이 5자 초과인 경우 실패 익셉션 테스트")
  void carCreateTest3() {
    String given = "pobirw";
    assertThatThrownBy(() -> CarFactory.of(given))
        .isInstanceOfAny(IllegalArgumentException.class)
        .hasMessageContaining(String.format(EXCEEDED_MAXIMUM_LENGTH, NAME_MAXIMUM_LENGTH, given, given.length()));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("자동차 이름이 null이나 empty 인 경우 실패 익셉션 테스트")
  void carCreateTest4(String given) {
    assertThatThrownBy(() -> CarFactory.of(given))
        .isInstanceOfAny(IllegalArgumentException.class)
        .hasMessageContaining(String.format(MUST_EXCEED_CERTAIN_LENGTH, NAME_MINIMUM_LENGTH, given));
  }

  @ParameterizedTest
  @CsvSource(value = {"poi;o:1"}, delimiter = ':')
  @DisplayName("잘못된 구분자가 있지만 5자 이하인 경우, 자동차 1대 정상 생성되는지 테스트")
  void carCreateTest5(String given, int expected) {
    Cars cars = CarFactory.of(given);
    assertThat(CarFactory.of(given).getCars()).hasSize(expected);
    assertThat(cars.getCars().get(0).getCarName().get()).isEqualTo(given);
  }
}
