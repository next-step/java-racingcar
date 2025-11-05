package caculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringCalculatorTest {

  @Test
  void 빈_문자열_또는_null_값을_입력할_경우_0을_반환한다() {
    int result = StringCalculator.splitAndSum("");

    assertThat(result).isEqualTo(0);
  }
}
