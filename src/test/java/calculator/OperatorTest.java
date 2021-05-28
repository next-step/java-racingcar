package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperatorTest {
    private int number1;
    private int number2;

    @BeforeEach
    void Setup() {
        number1 = 4;
        number2 = 2;
    }

    // 사칙연산 테스트
    @Test
    void addTest() {
        // given
        Operator operator = new Operator();

        // when
        int expected = 6;
        int actual = operator.add(number1, number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void subTest() {
        // given
        Operator operator = new Operator();

        // when
        int expected = 2;
        int actual = operator.sub(number1, number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void mulTest() {
        // given
        Operator operator = new Operator();

        // when
        int expected = 8;
        int actual = operator.mul(number1, number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    // 나누기 기능 테스트
    @ParameterizedTest
    @CsvSource(value = {"4,2","4,3"})
    void divTest(int num1, int num2) {
        // given
        Operator operator = new Operator();

        // when
        int expected = 2;
        int actual = operator.div(num1, num2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    // 나누기 예외 상황(0으로 나누기) 테스트
    @Test
     void divExceptionTest() {
        // given
        int num1 = 1;
        int num2 = 0;
        Operator operator = new Operator();

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> operator.div(num1, num2));
    }
}
