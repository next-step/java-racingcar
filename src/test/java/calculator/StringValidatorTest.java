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
  @CsvSource(value = {"123a,false", "11,true", "123,true", " 1a2, false"}, delimiter = ',')
  @DisplayName("isNumber Method 는 문자열이 숫자인지 반환한다.")
  public void isNumberTest(String input, boolean expected) {
    boolean number = StringValidator.isNumber(input);
    assertThat(number).isEqualTo(expected);
  }

  @Test
  @DisplayName("isNumber(null) 은 false 를 반환한다.")
  public void isNumberNullTest() {
    boolean number = StringValidator.isNumber(null);
    assertThat(number).isFalse();
  }

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