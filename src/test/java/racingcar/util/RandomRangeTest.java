package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomRangeTest {

  @RepeatedTest(10)
  @DisplayName("랜덤값이 0에서 9사이 값으로 구해지는지 확인")
  void checkedRandomValueZeroToNine() {
    int result = RandomRange.getRandomValue();

    assertThat(result).isBetween(0, 9);
  }
}