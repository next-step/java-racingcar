package study.racing.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberAssignerTest {

  public static int[] RANDOM_NUMBER_RANGE = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

  @Test
  void getRandomNumber() {
    for (int i = 0; i < 100; i++) {
      int randomNumber = RandomNumberAssigner.getRandomNumber();
      assertThat(RANDOM_NUMBER_RANGE).contains(randomNumber);
    }
  }
}
