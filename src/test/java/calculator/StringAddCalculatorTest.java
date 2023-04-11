package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StringAddCalculatorTest {

    @Test
    void 음수(){
        assertThatThrownBy(()->splitAndSum("-1,2:3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 콜론() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 컴마() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 숫자_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 빈문자열_null() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

}