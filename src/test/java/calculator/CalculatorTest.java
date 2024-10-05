package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    
    @Test
    public void splitAndSum_null_또는_빈문자() throws Exception {
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        assertThat(calculator.calculate("1")).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        assertThat(calculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> calculator.calculate("-1,2,3")
        )
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 포함되어 있습니다");
    }
}


