package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

  Game game;
  Random random;

  @BeforeEach
  void setUp() {
    game = new Game(new Random() {
      @Override
      public int nextInt(int bound) {
        return 4;
      }
    });
  }

  @ParameterizedTest
  @DisplayName("Game은 자동차를 입력받은 만큼 관리할 수 있다.")
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void gameContainsCars(int size) {
    // given
    // when
    game.initializeCars(size);

    // then
    assertThat(game.getCarSize()).isEqualTo(size);
  }

  @ParameterizedTest
  @DisplayName("Game은 입력받은 횟수만큼 자동차의 이동을 시도할 수 있다.")
  @CsvSource({"1,1,-", "2,1,-\n-", "1,2,--", "1,3,---"})
  void moveCars(int cars, int rounds, String result) {
    // given
    game.initializeCars(cars);

    // when
    game.moveCars(rounds);

    // then
    assertThat(game.getCarsStatus()).isEqualTo(result);
  }
}
