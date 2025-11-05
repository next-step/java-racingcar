package caculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringCalculatorTest {

  @Test
  void splitAndSum_null_또는_빈_문자열() {
    int result = StringCalculator.splitAndSum("");

    assertThat(result).isEqualTo(0);
  }

  @Test
  void splitAndSum_숫자하나() {
    int result = StringCalculator.splitAndSum("1");

    assertThat(result).isEqualTo(1);
  }
}
