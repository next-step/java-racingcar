package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAdditionCalculatorTest {

    //쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    @DisplayName("기본적인 문자열을 전달한 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {" =0", "1=1", "1,2=3", "1,2,3=6", "1,2:3=6"}, delimiter = '=')
    void basicSummaryTest(String input, Long expected){
        StringAdditionCalculator calculator = new StringAdditionCalculator();
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    //앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    // 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    @DisplayName("커스텀 구분자가 있는 문자열을 전달한 경우 테스트")
    @Test
    void customSeperatorTest(){
        StringAdditionCalculator calculator = new StringAdditionCalculator();
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6L);
    }

    //문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우, 예외처리에 대한 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-40", "2;3;summary", "hello:world,"})
     void throwExceptionTest(String input){
        StringAdditionCalculator calculator = new StringAdditionCalculator();
        assertThatThrownBy(()->
                calculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }
}