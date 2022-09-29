package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MovingStrategy;
import racingcar.RandomMovingStrategy;

public class RandomNumTest {

  @Test
  @DisplayName("랜덤값 0 이상 10 미만")
  void testRandomNum0to9() {
    MovingStrategy movingStrategy = new RandomMovingStrategy();
    int randomNum = movingStrategy.getRandNum();
    Assertions.assertThat(randomNum).isBetween(0, 9);
  }
}
