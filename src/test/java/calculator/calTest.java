package calculator;

import org.junit.jupiter.api.Test;

import static calculator.Calculator.cal;
import static org.assertj.core.api.Assertions.assertThat;

public class calTest {

    @Test
    void 컴마_구분자(){
        assertThat(cal("1,2")).isEqualTo(3);
    }

    @Test
    void 숫자_하나(){
        assertThat(cal("1")).isEqualTo(1);
    }

    @Test
    void null_빈문자열_값(){
        assertThat(cal(null)).isEqualTo(0);
        assertThat(cal("")).isEqualTo(0);
    }
}
