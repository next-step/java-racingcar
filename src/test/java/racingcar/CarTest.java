package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

  static Stream<Arguments> distances() {
    return Stream.of(
        Arguments.arguments(0, ""),
        Arguments.arguments(1, "-"),
        Arguments.arguments(2, "--"),
        Arguments.arguments(3, "---")
    );
  }

  @ParameterizedTest
  @DisplayName("자동차는 4이상이면 전진하고, 미만이면 정지한다.")
  @CsvSource({"3,false", "0,false", "4,true", "9,true"})
  void move(int randomNumber, boolean expected) {
    Car car = new Car();

    assertThat(car.move(randomNumber)).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("해당 횟수만큼 전진한 자동차의 상태를 확인한다. 이동 거리는 '-'로 표시한다.")
  @MethodSource("distances")
  void status(int distance, String expected) {
    Car car = new Car();

    for (int i = 0; i < distance; i++) {
      car.move(4);
    }

    assertThat(car.showStatus()).isEqualTo(expected);
  }
}
