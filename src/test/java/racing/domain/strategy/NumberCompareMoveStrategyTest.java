package racing.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberCompareMoveStrategyTest {

  @ParameterizedTest
  @DisplayName("생성된 숫자에 의해 움직이거나 움직이지 않는 조건이 되는지 확인")
  @CsvSource(value = {"1|false", "2|false", "5|true", "10|true"}, delimiter = '|')
  void moveTest(int number, boolean expected) {
    NumberCompareMoveStrategy numberCompareMoveStrategy = new NumberCompareMoveStrategy(
        new FixedNumberGenerator(number));

    assertThat(numberCompareMoveStrategy.canMove()).isEqualTo(expected);
  }
}