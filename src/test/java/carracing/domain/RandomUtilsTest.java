package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {

  @ParameterizedTest
  @CsvSource(value = {"-1:true", "-2:true", "0:true", "11:false", "15:false", "13:false"}, delimiter = ':')
  @DisplayName("1-10사이의 무작위로 발생하는 값이 주어진 값 이상이면 true, 주어진 값 이하라면 false를 발생한다.")
  void greaterThanOrEqualsTest(int input, boolean result) {
    assertThat(RandomUtils.greaterThanOrEquals(input)).isEqualTo(result);
  }

}