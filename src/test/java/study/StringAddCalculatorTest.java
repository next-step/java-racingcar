package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    
    private StringAddCalculator calculator = new StringAddCalculator();

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void emptyStringOrNull (){
        assertThat(calculator.add("")).isEqualTo(0);
        assertThat(calculator.add(null)).isEqualTo(0);
    }
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    @ParameterizedTest(name = "input=> {0} output=> {1}")
    @CsvSource(value = {"1,1","3,3","14,14","5,5"})
    void onlyOneInput (String input, int expected){
        assertThat(calculator.add(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    void addString(){
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    void delimiterCommaAndColon(){
        assertThat(calculator.add("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)")
    void customDelimiter(){
        assertThat(calculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    void inputContainsMinusValue(){
        assertThatThrownBy(() -> calculator.add("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
