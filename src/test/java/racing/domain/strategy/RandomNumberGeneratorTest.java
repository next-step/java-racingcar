package racing.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

  @RepeatedTest(100)
  @DisplayName("100 회동안 랜덤 숫자가 범위내에서 잘 생성 되는지 확인")
  void randomNumberTest() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    assertThat(randomNumberGenerator.generate()).isBetween(0, 9);
  }
}