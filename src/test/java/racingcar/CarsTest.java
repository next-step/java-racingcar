package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static racingcar.Car.UNIT;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

  Cars cars;
  Random random;

  static Stream<Arguments> carMovements() {
    return Stream.of(
        arguments(Lists.list(Car.create("a")), "a : " + UNIT),
        arguments(Lists.list(Car.create("a"), Car.create("b")), "a : " + UNIT + System.lineSeparator() + "b : " + UNIT),
        arguments(Lists.list(Car.create("a"), Car.create("b"), Car.create("c")),
            "a : " + UNIT + System.lineSeparator() + "b : " + UNIT + System.lineSeparator() + "c : " + UNIT)
    );
  }

  static Stream<Arguments> carNamesAndSize() {
    return Stream.of(
        arguments(Lists.list(Car.create("a")), 1),
        arguments(Lists.list(Car.create("a"), Car.create("b")), 2),
        arguments(Lists.list(Car.create("a"), Car.create("b"), Car.create("c")), 3),
        arguments(Lists.list(Car.create("a"), Car.create("b"), Car.create("c"), Car.create("d")), 4),
        arguments(Lists.list(Car.create("a"), Car.create("b"), Car.create("c"), Car.create("d"), Car.create("e")), 5)
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
  @MethodSource("carNamesAndSize")
  void initialize(List<Car> carList, int size) {
    // given
    // when
    cars.initialize(carList);

    // then
    assertThat(cars.getCarCount()).isEqualTo(size);
  }


  @ParameterizedTest
  @DisplayName("Cars는 차량 전체의 전진을 시도할 수 있다.")
  @MethodSource("carMovements")
  void moveCars(List<Car> carList, String result) {
    // given
    cars.initialize(carList);

    // when
    cars.moveAll();

    // then
    assertThat(cars.getNameAndStatus()).isEqualTo(result);
  }

  @Test
  @DisplayName("게임에서 우승한 우승자를 알 수 있다.")
  void winner() {
    // given
    String[] names = {"a", "b"};
    cars.initialize(Arrays.stream(names).map(Car::create).collect(Collectors.toList()));

    // when
    cars.moveAll();

    // then
    assertThat(cars.getWinner().getWinners()).contains(names);
  }
}
