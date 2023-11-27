package calculator;

import static calculator.Calculator.cal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("1. 빈 값이 들어오면 0 반환")
    void nullParam() {
        assertThat(cal(null)).isEqualTo(0);
        assertThat(cal("")).isEqualTo(0);
    }

    @Test
    @DisplayName("2. 숫자 하나 입력")
    void singleNumber(){
        assertThat(cal("1")).isEqualTo(1);
        assertThat(cal("2")).isEqualTo(2);
        assertThat(cal("3")).isEqualTo(3);
    }

    @Test
    @DisplayName("3. 숫자 2개를 컴마(,) 구분자로 입력")
    void commaDoubleNumber(){
        assertThat(cal("1,2")).isEqualTo(3);
        assertThat(cal("3,4")).isEqualTo(7);
    }

    @Test
    @DisplayName("4. 구분자로 콜론(:) 사용")
    void useColon(){
        assertThat(cal("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("5. //, \\n 사이에 있는 커스텀 구분자 사용")
    void useCustomDelimiter(){
        assertThat(cal("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("6. 음수인 경우 RuntimeException 발생")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> cal("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

}
