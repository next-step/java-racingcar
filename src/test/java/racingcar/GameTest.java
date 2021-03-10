package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
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

class GameTest {

  Game game;
  Random random;

  static Stream<Arguments> carMovements() {
    return Stream.of(
        arguments(Lists.list(Car.create("a")), 1, "a : " + UNIT),
        arguments(Lists.list(Car.create("a"), Car.create("b")),
            1, "a : " + UNIT + System.lineSeparator() + "b : " + UNIT),
        arguments(Lists.list(Car.create("a")), 2, "a : " + UNIT + UNIT),
        arguments(Lists.list(Car.create("a")), 3, "a : " + UNIT + UNIT + UNIT)
    );
  }

  static Stream<List<Car>> cars() {
    return Stream.of(
        Lists.list(Car.create("a")),
        Lists.list(Car.create("a"), Car.create("b")),
        Lists.list(Car.create("a"), Car.create("b"), Car.create("c")),
        Lists.list(Car.create("a"), Car.create("b"), Car.create("c"), Car.create("d")),
        Lists.list(Car.create("a"), Car.create("b"), Car.create("c"), Car.create("d"), Car.create("e"))
    );
  }

  static Stream<Arguments> gameResults() {
    return Stream.of(
        arguments(Lists.list(Car.create("a")), 1, "a : " + UNIT),
        arguments(Lists.list(Car.create("a")), 2, "a : " + UNIT + UNIT),
        arguments(Lists.list(Car.create("a"), Car.create("b")),
            2, "a : " + UNIT + UNIT + System.lineSeparator() + "b : " + UNIT + UNIT)
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
    game = new Game(random);
  }

  @ParameterizedTest
  @DisplayName("Game은 자동차를 입력받은 만큼 관리할 수 있다.")
  @MethodSource("cars")
  void gameContainsCars(List<Car> cars) {
    // given
    // when
    game.initialize(cars);

    // then
    assertThat(game.getCarCount()).isEqualTo(cars.size());
  }

  @ParameterizedTest
  @DisplayName("Game은 입력받은 횟수만큼 자동차의 이동을 시도할 수 있다.")
  @MethodSource("carMovements")
  void moveCars(List<Car> cars, int rounds, String result) {
    // given
    game.initialize(cars);

    // when
    game.moveCars(rounds);

    // then
    assertThat(game.getCarsNameAndStatus()).isEqualTo(result);
  }

  @ParameterizedTest
  @DisplayName("게임은 자동차의 수와 횟수를 입력받아 게임을 진행할 수 있다.")
  @MethodSource("gameResults")
  void startGame(List<Car> cars, int rounds, String result) {
    // given
    // when
    game.start(cars, rounds);

    // then
    assertThat(game.getCarsNameAndStatus()).isEqualTo(result);
  }

  @Test
  @DisplayName("게임에서 우승한 우승자를 알 수 있다.")
  void winner() {
    // given
    // when
    String[] names = {"a", "b"};
    game.start(Arrays.stream(names).map(Car::create).collect(Collectors.toList()), 2);

    // then
    assertAll(
        () -> assertThat(game.getWinners()).contains(names),
        () -> assertThat(game.getWinnerListString()).isEqualTo(String.join(", ", names))
    );
  }
}
