package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {
    private final Operator operator = new Operator();
    private int number1;
    private int number2;

    @BeforeEach
    void Setup() {
        number1 = 4;
        number2 = 2;
    }

    // 사칙연산 테스트
    @Test
    @DisplayName("더하기 테스트")
    void addTest() {
        // given
        int expected = 6;
        int actual = operator.add(number1, number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("빼기 테스트")
    void subTest() {
        // given
        int expected = 2;
        int actual = operator.sub(number1, number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void mulTest() {
        // given
        int expected = 8;
        int actual = operator.mul(number1, number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("나누기 정상 테스트")
    void divTest() {
        // given
        int expected = 2;
        int actual = operator.div(number1,number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("나누기 예외 테스트(0으로 나누기)")
     void divExceptionTest() {
        // given
        int num1 = 2;
        int num2 = 0;

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> operator.div(num1, num2));
    }
}
