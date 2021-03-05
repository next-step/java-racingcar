package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static racingcar.Car.UNIT;

import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

  Cars cars;
  Random random;

  static Stream<Arguments> carMovements() {
    return Stream.of(
        arguments(1, UNIT),
        arguments(2, UNIT + System.lineSeparator() + UNIT),
        arguments(3, UNIT + System.lineSeparator() + UNIT + System.lineSeparator() + UNIT)
    );
  }

  @BeforeEach
  void setUp() {
    random = new Random() {
      @Override
      public int nextInt(int bound) {
        return 4;
      }
    };
    cars = new Cars(random);
  }

  @ParameterizedTest
  @DisplayName("Cars는 자동차를 입력받은 만큼 관리할 수 있다.")
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void initialize(int size) {
    // given
    // when
    cars.initialize(size);

    // then
    assertThat(cars.getCarCount()).isEqualTo(size);
  }


  @ParameterizedTest
  @DisplayName("Cars는 차량 전체의 전진을 시도할 수 있다.")
  @MethodSource("carMovements")
  void moveCars(int carCount, String result) {
    // given
    cars.initialize(carCount);

    // when
    cars.moveAll();

    // then
    assertThat(cars.getStatus()).isEqualTo(result);
  }
}
