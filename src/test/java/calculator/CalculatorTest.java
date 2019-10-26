package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

  private String[] OPERATATOR = new String[]{"+","-","*","/"};

  @ParameterizedTest
  @NullSource
  @DisplayName("1.1. Null 체크")
  void validateNullArgs(String args) {
    assertThat(args).isBlank();
  }


  @ParameterizedTest
  @ValueSource(strings = {"2 + 3 * 4 / 2"})
  @DisplayName("1.2. 홀수번째 텍스트가 허용된 연산자인지 체크")
  void validateOddTextOperatorArgs(String args) {
    String[] arg = args.split(" ");
    for(int i=0; i<arg.length; i++){
      if(i%2 != 0){
        assertThat(OPERATATOR).contains(arg[i]);
      }
    }
  }


  @ParameterizedTest
  @ValueSource(strings = {"2 + 3 * 4 / 2"})
  @DisplayName("1.3. 짝수번째 텍스트가 숫자인지 체크")
  void validateEvenTextNumberArgs(String args) {
    String[] arg = args.split(" ");
    for(int i=0; i<arg.length; i++){
      if(i%2 == 0){
        assertThat(Integer.parseInt(arg[i])).isInstanceOf(Integer.class);
      }
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"2 + 3 * 4 / 2"})
  @DisplayName("1.4. 입력받는 값은 값의 크기는 3보다 크고, 홀수개의 값이다.")
  void validateTextFormatArgs(String args) {
    String[] arg = args.split(" ");
    assertThat(arg.length).isGreaterThanOrEqualTo(3);
    assertThat(arg.length % 2).isEqualTo(1);
  }

}