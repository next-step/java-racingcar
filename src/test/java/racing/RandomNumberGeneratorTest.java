package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racing.util.RandomNumberGenerator;

class RandomNumberGeneratorTest {

  @Test
  void 숫자9까지의_랜덤한_숫자_부여() {
    int number = RandomNumberGenerator.generate();

    assertThat(number).isBetween(0, 9);
  }
}