package racing.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FixedNumberGeneratorTest {

  @ParameterizedTest
  @DisplayName("고정된 숫자가 생성 되는지 확인")
  @CsvSource(value = {"1|1", "2|2", "5|5", "10|10"}, delimiter = '|')
  void fixNumberTest(int number, int expected) {
    FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(number);
    assertThat(fixedNumberGenerator.generate()).isEqualTo(expected);
  }
}