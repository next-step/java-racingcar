package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomTest {

  @RepeatedTest(100)
  @DisplayName("nextInt를 수행했을 때, 0~9 사이의 값이 나와야한다.")
  void nextInt() {
    int actual = new Random().nextInt(10);

    assertAll(
        () -> assertThat(actual).isBetween(0, 9),
        () -> assertThat(actual).isIn(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    );
  }
}
