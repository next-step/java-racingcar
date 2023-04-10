package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

  @Test
  void 숫자9까지의_랜덤한_숫자_부여() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    int number = randomNumberGenerator.generate();
    assertThat(number).isBetween(0, 9);
  }
}