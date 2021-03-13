package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.controller.Game;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
  Game game;

  @BeforeEach
  void setup() {
    game = new Game();
  }

  @ParameterizedTest
  @CsvSource(value = {"0,1", "0,5", "2,0", "0,0", "4,0"})
  @DisplayName("자동차 대수, 수행 횟수에 0 값이 들어올 경우 예외를 처리하는 지 여부 체크")
  void checkInvalidInputValueTest(int carCount, int attempt) {
    assertThat(game.run(carCount, attempt)).isEqualTo(false);
  }

  @ParameterizedTest
  @CsvSource(value = {"2,1", "3,5", "2,4", "2,6", "4,3"})
  @DisplayName("자동차 대수, 수행 횟수가 정상적일 경우 게임을 제대로 수행하는지 여부 체크")
  void checkValidInputValueTest(int carCount, int attempt) {
    assertThat(game.run(carCount, attempt)).isEqualTo(true);
  }

}
