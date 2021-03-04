package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringValidatorTest {

  @ParameterizedTest
  @DisplayName("isOperator() 는 + - * / 만 true를 리턴한다.")
  @CsvSource(value = {"+,true", "-,true", "\\,false", "/,true", "&,false", "*,true"})
  public void isOperatorTest(String input, boolean expected) throws Exception {
    boolean number = StringValidator.isOperator(input);
    assertThat(number).isEqualTo(expected);
  }

  @Test
  @DisplayName("isBlank 는 빈칸과 null은 false를 리턴한다.")
  public void isBlankTest() {
    assertAll(
        () -> assertTrue(StringValidator.isBlank("")),
        () -> assertTrue(StringValidator.isBlank(null)),
        () -> assertFalse(StringValidator.isBlank("123asd"))
    );
  }
}