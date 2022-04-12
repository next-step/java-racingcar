package racing.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

  @Test
  @DisplayName("랜덤 숫자가 생성 되는지 확인")
  void randomNumberTest() {
    int loop = 100;
    for (int i = 0; i < loop; i++) {
      RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
      assertThat(randomNumberGenerator.generate()).isBetween(0, 9);
    }
  }
}