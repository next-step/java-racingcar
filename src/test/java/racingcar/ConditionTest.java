package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ConditionTest {
  @ParameterizedTest
  @CsvSource(value = { "3:true", "5:true", "7:false" }, delimiter = ':' )
  void 크거나_같으면_참(int input, boolean expected) {
    Assertions.assertThat(new Condition(5).equalOrLargerThan(input)).isEqualTo(expected);
  }
}
