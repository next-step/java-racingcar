package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

  @ParameterizedTest
  @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 5, Integer.MAX_VALUE})
  @DisplayName("CarName의 이름 길이는 유효 범위를 넘을 수 없다")
  void rangeExceptionTest(int count) {
    assertThatThrownBy(() -> new CarName("a".repeat(count)))
        .isInstanceOf(IllegalArgumentException.class);
  }
}