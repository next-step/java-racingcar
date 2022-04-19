package util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

  @Test
  void generate() {
    final int maxNumber = 10;
    for (int i = 0 ; i < 100 ; i++) {
      assertThat(RandomNumberGenerator.generateRandomNumberInRange(maxNumber)).isLessThan(maxNumber);
    }
  }
}
