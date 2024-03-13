package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CriteriaTest {
  @ParameterizedTest
  @CsvSource(value = { "3:true", "5:true", "10:false" }, delimiter = ':')
  void 조건이_기준을_만족해야만_참(int input, boolean expected) {
    Assertions.assertThat(new Criteria(input).accepts(new Condition(5))).isEqualTo(expected);
  }
}
