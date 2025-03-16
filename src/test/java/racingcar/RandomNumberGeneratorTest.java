package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
  @Test
  void generateRandomNumber() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    int randomNumber = randomNumberGenerator.generateNumber();
    assertThat(randomNumber).isBetween(0, 9);
  }

}
