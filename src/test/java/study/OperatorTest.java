package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorTest {
    @Test
    void plusTest() throws Exception {
        assertThat(Operator.PLUS.operate(1,2)).isEqualTo(3);
    }

    @Test
    void minusTest() throws Exception {
        assertThat(Operator.MINUS.operate(1,2)).isEqualTo(-1);
    }

    @Test
    void multiplyTest() throws Exception {
        assertThat(Operator.MULTIPLY.operate(1, 2)).isEqualTo(2);
    }

    @Test
    void divideTest() throws Exception {
        assertThat(Operator.DIVIDE.operate(4, 2)).isEqualTo(2);
    }

    @Test
    void divideTest_ShouldReturnCustomizedException() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    Operator.DIVIDE.operate(4, 3);
                }).withMessageMatching("나눗셈의 경우. 결과 값이 정수로 떨어지는 경우로 한정됩니다.");
    }
}
