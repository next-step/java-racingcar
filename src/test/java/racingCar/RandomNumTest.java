package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RandomNum;

public class RandomNumTest {

  @Test
  @DisplayName("랜덤값 0 이상 10 미만")
  void testRandomNum0to9() {
    RandomNum randomNum = new RandomNum();
    Assertions.assertThat(randomNum.createRandNum()).isBetween(0, 9);
  }
}
