package study.step4;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step4.model.RacingGame;

public class CarTest {

  @DisplayName("자동차 이름 길이 제한 성공 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"car1", "car1,car2", "car1,car2,car3"})
  public void carNameLenghthSuccessTest(String carNames) {
    final int carGameRound = 5;
    assertDoesNotThrow(() -> new RacingGame(carNames, carGameRound));
  }

  @DisplayName("자동차 이름 길이 제한 실패 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"car123", "car123,car234", "car123,car234,car345"})
  public void carNameLenghthFailTest(String carNames) {
    final int carGameRound = 5;
    assertThrows(IllegalArgumentException.class, () -> new RacingGame(carNames, carGameRound));
  }
}
