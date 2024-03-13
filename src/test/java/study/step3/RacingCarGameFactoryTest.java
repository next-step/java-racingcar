package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.step3.domain.Car;
import racingcar.step3.domain.RacingCarGameFactory;
import racingcar.step3.domain.strategy.RandomCarMoveStrategy;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.step3.domain.RacingCarGameFactory.NUMBER_OR_CARS_IS_INCORRECT;
import static racingcar.step3.domain.RacingCarGameFactory.NUMBER_OR_ROUND_IS_INCORRECT;

@DisplayName("자동차 경주 테스트")
public class RacingCarGameFactoryTest {

  private static final List<Car> CARS = List.of(
      new Car("car1", new RandomCarMoveStrategy()),
      new Car("car2", new RandomCarMoveStrategy())
  );

  @ParameterizedTest
  @MethodSource("getCorrectTestCases")
  @DisplayName("자동차 경주 생성 테스트")
  void racingCarGameCreateTest(int given, int expected) {
    assertThat(RacingCarGameFactory.of(given, CARS)).hasSize(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"0", "-100"})
  @DisplayName("경주 횟수가 음수 또는 0이 들어온 경우, 자동차 경주 생성 실패 테스트")
  void racingCarGameCreateTest2(int given) {
    assertThatThrownBy(() -> RacingCarGameFactory.of(given, CARS))
        .isInstanceOfAny(IllegalArgumentException.class)
        .hasMessageContaining(String.format(NUMBER_OR_ROUND_IS_INCORRECT, given));
  }

  @Test
  @DisplayName("경주할 자동차가 없는 경우, 자동차 경주 생성 실패 테스트")
  void racingCarGameCreateTest3() {
    List<Car> emptyCars = List.of();
    assertThatThrownBy(() -> RacingCarGameFactory.of(1, emptyCars))
        .isInstanceOfAny(IllegalArgumentException.class)
        .hasMessageContaining(String.format(NUMBER_OR_CARS_IS_INCORRECT, emptyCars.size()));
  }

  private static Stream<Arguments> getCorrectTestCases() {
    return Stream.of(
        Arguments.of("1", 1),
        Arguments.of("3", 3),
        Arguments.of("5", 5),
        Arguments.of("10", 10)
    );
  }
}
