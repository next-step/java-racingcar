package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.step3.domain.Car;
import racingcar.step3.domain.CarFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.step3.domain.Car.DEFAULT_MOVE_COUNT;
import static racingcar.step3.domain.Car.MEET_CONDITION_FOR_MOVEMENT;
import static racingcar.step3.domain.CarFactory.NUMBER_OR_CARS_IS_INCORRECT;

public class CarTest {
  @Nested
  @DisplayName("자동차 생성 테스트")
  class CarCreateTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "4:4"}, delimiter = ':')
    @DisplayName("n대의 자동차가 생성되는지 테스트")
    void carCreateTest(int given, int expected) {
      assertThat(CarFactory.of(given)).hasSize(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "-100"})
    @DisplayName("음수 또는 0이 들어온 경우 자동차 생성 실패 테스트")
    void carCreateTest2(int given) {
      assertThatThrownBy(() -> CarFactory.of(given))
          .isInstanceOfAny(IllegalArgumentException.class)
          .hasMessageContaining(String.format(NUMBER_OR_CARS_IS_INCORRECT, given));
    }
  }

  @Nested
  @DisplayName("자동차 이동 테스트")
  class CarMoveTest {
    @Test
    @DisplayName("자동차 전진 테스트")
    void carMoveTest() {
      Car car = new Car("car1");
      int randomNumber = MEET_CONDITION_FOR_MOVEMENT + 1;
      car.move(randomNumber);
      assertThat(car.getMoveCount()).isEqualTo(DEFAULT_MOVE_COUNT + 1);
    }

    @Test
    @DisplayName("자동차가 멈추는지 테스트")
    void carMoveTest2() {
      Car car = new Car("car1");
      int randomNumber = MEET_CONDITION_FOR_MOVEMENT - 1;
      car.move(randomNumber);
      assertThat(car.getMoveCount()).isEqualTo(DEFAULT_MOVE_COUNT);
    }
  }
}
