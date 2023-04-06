

//요구 사항
// 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
// 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
// 숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다.
// 구분자를 컴마 이외에 콜론을 사용할 수 있다.
// "\\"와 "\n" 문자 사이엥 커스텀 구분자를 지정할 수 있다.
// 음수를 전달할 경우 RuntimeException 예외가 발생

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {


    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @NullSource
    @ValueSource(strings = {"", " "})
    public void blackCheck(String input) throws Exception {
        //given
        int result = Calculator.splitAndSum(input);
        //when
        int expected = 0;
        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ValueSource(strings = {"1","2","10"})
    public void whenInputisSingleNumber(String input) throws Exception {
        //given
        int result = Calculator.splitAndSum(input);
        //when
        int expected = Integer.parseInt(input);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @CsvSource(value = {"1,2:3","2,3:5","10,11:21"}, delimiter = ':')
    public void whenInputisTwoNumbers(String input, String expected) throws Exception {
        int result = Calculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @DisplayName("구분자로 콜론도 사용할 때")
    @CsvSource(value = {"1:2,3;6","2,3:5;10"}, delimiter = ';')
    public void 구분자로_콜론도_사용(String input, String expected) throws Exception {
        int result = Calculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }


    @Test
    @DisplayName("커스텀 구분자를 지정할 때")
    public void 커스텀_구분자_사용() throws Exception {
        int result = Calculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("음수_예외_처리")
    @ValueSource(strings = {"-1,2,3", "1,2,-10"})
    public void 음수_예외_처리(String input) throws Exception {
        assertThatThrownBy(() -> Calculator.splitAndSum(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
