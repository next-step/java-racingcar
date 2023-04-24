package racing.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberGeneratorStrategyTest {

  @Test
  void 랜덤값구할수있다() {
    RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();

    int result = randomNumberStrategy.getNumber();

    assertThat(result).isBetween(0, 9);
  }

}