package racingrefactoring.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

  @Test
  void 범위_안의_숫자_랜덤_생성() {
    int number = RandomNumberGenerator.generateNumber();

    assertThat(number).isBetween(0, 9);
  }
}