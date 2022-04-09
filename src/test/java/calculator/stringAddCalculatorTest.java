package calculator;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class stringAddCalculatorTest {
    @Test
    @Order(1)
    void 빈문자열이나_null일_경우() {
        assertThat(StringAddCalculator.splitAndSum(null)).isZero();
        assertThat(StringAddCalculator.splitAndSum("")).isZero();
    }

    @Test
    @Order(2)
    void 숫자하나를_문자열로_입력할경우() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @Order(3)
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1:2,3", "1,2,3", "1:2:3"})
    @Order(4)
    void 콤마_콜론_구분자(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(6);
    }

    @Test
    @Order(5)
    void 패턴_사이_커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @Order(6)
    void 문자열에_음수를_전달할_경우() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}



