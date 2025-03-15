package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 값, null을 입력하면 0을 보낸다.")
    public void test1(String input){
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 문자열로 입력할 경우 해당 숫자를 반환한다.")
    public void test2(){
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2"})
    @DisplayName(", :를 구분자로 숫자를 연속해서 입력하면 두 숫자의 합을 반환한다.")
    public void test3(String input){
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(3);
    }

    @Test
    @DisplayName("//와 \n 문자 사이에 커스텀 문자를 지정할 수 있다.")
    public void test4(){
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 입력한 경우 RuntimeException이 발생한다.")
    public void test5(){
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열만을 입력하면 예외를 발생시킨다.")
    public void test6(){
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-a,b,c"))
                .isInstanceOf(RuntimeException.class);
    }

}