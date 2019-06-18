package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.util.RandomValueUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

  @DisplayName("랜덤함수 테스트")
  @RepeatedTest(10)
  void getRandomValue() {
    int randomValue = RandomValueUtil.getRandomValue();
    assertThat(randomValue).isGreaterThan(-1)
        .isLessThan(10);
  }
}
