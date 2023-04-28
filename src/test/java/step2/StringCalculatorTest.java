package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("빈문자열이나 null이 입력된 경우 0을 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    public void test1(String expression){
        int result = stringCalculator.calculate(expression);
        int expected = 0;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 하나만 입력된 경우 그 숫자를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "12:12", "444:444"}, delimiter = ':')
    public void test2(String expression, int expected){
        int result = stringCalculator.calculate(expression);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 ,로 구분하여 넘긴 경우 두 수의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6", "3,4,5:12", "111,111,222:444"}, delimiter = ':')
    public void test3(String expression, int expected){
        int result = stringCalculator.calculate(expression);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("구분자를 ,와 :을 사용할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3;6", "3:4,5;12", "111,111:222;444"}, delimiter = ';')
    public void test4(String expression, int expected){
        int result = stringCalculator.calculate(expression);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자를 지정할 수 있다")
    @Test
    public void test5(){
        // given
        // when
        int result = stringCalculator.calculate("//;\n1;2;3");
        int expected = 6;


        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("음를 전달할 경우 RuntimeException을 발생키신다")
    @ParameterizedTest
    @ValueSource(strings = {"1,-2:3", "-3:4,5", "111,111:-222"})
    public void test6(String expression){
        assertThatThrownBy(() -> stringCalculator.calculate(expression)).isInstanceOf(RuntimeException.class);
    }

}