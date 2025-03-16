package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.random.RandomNumberGenerator;

class RandomNumberGeneratorTest {
  @Test
  void generateRandomNumber() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    int randomNumber = randomNumberGenerator.generateNumber();
    assertThat(randomNumber).isBetween(0, 9);
  }

}
