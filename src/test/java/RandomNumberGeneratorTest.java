import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

  @Test
  void generate() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    for (int i = 0 ; i < 10 ; i++) {
      assertThat(randomNumberGenerator.generate()).isLessThan(10);
    }
  }
}
