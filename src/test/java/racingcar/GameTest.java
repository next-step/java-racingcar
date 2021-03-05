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

class GameTest {

  Game game;
  Random random;

  static Stream<Arguments> carMovements() {
    return Stream.of(
        arguments(1, 1, UNIT),
        arguments(2, 1, UNIT + System.lineSeparator() + UNIT),
        arguments(1, 2, UNIT + UNIT),
        arguments(1, 3, UNIT + UNIT + UNIT)
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
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void gameContainsCars(int size) {
    // given
    // when
    game.initialize(size);

    // then
    assertThat(game.getCarCount()).isEqualTo(size);
  }

  @ParameterizedTest
  @DisplayName("Game은 입력받은 횟수만큼 자동차의 이동을 시도할 수 있다.")
  @MethodSource("carMovements")
  void moveCars(int cars, int rounds, String result) {
    // given
    game.initialize(cars);

    // when
    game.moveCars(rounds);

    // then
    assertThat(game.getCarsStatus()).isEqualTo(result);
  }

  static Stream<Arguments> gameResults() {
    return Stream.of(
        arguments(1, 1, UNIT),
        arguments(1, 2, UNIT + UNIT),
        arguments(2, 2, UNIT + UNIT + System.lineSeparator() + UNIT + UNIT)
    );
  }

  @ParameterizedTest
  @DisplayName("게임은 자동차의 수와 횟수를 입력받아 게임을 진행할 수 있다.")
  @MethodSource("gameResults")
  void startGame(int cars, int rounds, String result) {
    // given
    // when
    game.start(cars, rounds);

    // then
    assertThat(game.getCarsStatus()).isEqualTo(result);
  }
}
