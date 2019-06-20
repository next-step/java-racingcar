package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.RacingGame;
import racinggame.util.RandomValueUtil;
import racinggame.util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

  @DisplayName("랜덤함수 테스트")
  @RepeatedTest(10)
  void getRandomValue() {
    int randomValue = RandomValueUtil.getRandomValue();
    assertThat(randomValue).isGreaterThan(-1)
        .isLessThan(10);
  }

  @DisplayName("RacingInfo 생성 테스트")
  @ParameterizedTest
  @ValueSource(ints = {2, 3, 7})
  void racingInfo(int time) {
    RacingGame racingGame = new RacingGame("test1, test2, test3", time);
    assertThat(racingGame.startGame()).hasSize(time);
  }

  @Test
  void getCarRacingPrint() {
    String testValue = StringUtil.getCarRacingPrint("test", 3);
    assertThat(testValue).isEqualTo("test : ---");
  }
}
