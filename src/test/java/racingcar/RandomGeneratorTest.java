package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;

public class RandomGeneratorTest {

  @Test
  @DisplayName("[RandomGenerator] 0~9 random 값 발생 테스트")
  void generateRandomNumberTest() {
    assertThat(RandomGenerator.generateRandomNumber(10)).isBetween(0, 9);
  }
}
