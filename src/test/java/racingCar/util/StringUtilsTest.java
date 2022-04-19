package racingCar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

  @Test
  @DisplayName("문자열 split을 테스트한다.")
  void splitTest() {
    assertThat(StringUtils.split("a,b,c", ",")).contains("a", "b", "c");
  }
}