package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberValidatorTest {

  @ParameterizedTest
  @CsvSource(value = {"123a,false", "11,true", "123,true", " 1a2, false"}, delimiter = ',')
  @DisplayName("isNumber Method 는 문자열이 숫자인지 반환한다.")
  public void isNumberTest(String input, boolean expected) {
    boolean number = NumberValidator.isNumber(input);
    assertThat(number).isEqualTo(expected);
  }

  @Test
  @DisplayName("isNumber(null) 은 false 를 반환한다.")
  public void isNumberNullTest() {
    boolean number = NumberValidator.isNumber(null);
    assertThat(number).isFalse();
  }
}