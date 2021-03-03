package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2021/03/03.
 * @project java-racingcar
 * @description
 */
public class calculatorTest {

  @DisplayName("덧셈 테스트")
  @Test
  void plus() {
    Calculator calculator = new Calculator();
    int result = calculator.plus(2, 3);
    assertThat(result).isEqualTo(5);
  }

}
