package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {
    StringCalculator stringCalculator;
    private final static String EMPTY_EXPRESSION_MESSAGE = "수식이 비었거나 null 입니다.";
    private final static String WRONG_EXPRESSION_MESSAGE = "수식이 잘못되었습니다.";
    private final static String NOT_DIVIDE_BY_ZERO_MESSAGE = "0으로 나눌 수 없습니다.";

    @BeforeEach
    void setUpCalCulate() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("null or 빈값 테스트 실패 케이스")
    void nullOrEmptyTest() {
        Throwable exception = assertThrows(EmptyExpressionException.class, () -> {
            stringCalculator.calculate(" ");
        });
        assertThat(exception.getMessage()).isEqualTo(EMPTY_EXPRESSION_MESSAGE);
    }

    @Test
    @DisplayName("첫번째 수식 테스트 실패 케이스")
    void firstCalculateTest() {
        Throwable exception = assertThrows(WrongExpressionException.class, () -> {
            stringCalculator.calculate("1 + 3 + +");
        });
        assertThat(exception.getMessage()).isEqualTo(WRONG_EXPRESSION_MESSAGE);
    }

    @Test
    @DisplayName("계산 성공 케이스")
    void calculateSuccess() {
        double result = stringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("0나누기 실패 케이스")
    void divideByZero() {
        Throwable exception = assertThrows(NotDivideByZeroException.class, () -> {
            stringCalculator.calculate("2 / 0");
        });
        assertThat(exception.getMessage()).isEqualTo(NOT_DIVIDE_BY_ZERO_MESSAGE);
    }

    @Test
    @DisplayName("다른연산 하다가 0으로 나누기 실패 케이스")
    void caculateThenDivideByZero() {
        Throwable exception = assertThrows(NotDivideByZeroException.class, () -> {
            stringCalculator.calculate("1 + 2 / 0");
        });
        assertThat(exception.getMessage()).isEqualTo(NOT_DIVIDE_BY_ZERO_MESSAGE);
    }
}