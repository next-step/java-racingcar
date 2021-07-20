package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUpCalCulate() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("null or 빈값 테스트 실패 케이스")
    void nullOrEmptyTest() {
        stringCalculator.calculate(" ");
    }

    @Test
    @DisplayName("첫번째 수식 테스트 실패 케이스")
    void firstCalculateTest() {
        stringCalculator.calculate("1 + 3 + +");
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
        double result = stringCalculator.calculate("2 / 0");
    }

    @Test
    @DisplayName("사칙연산 하다가 0으로 나누기 실패 케이스")
    void caculateThenDivideByZero() {
        System.out.println(stringCalculator.calculate("1 + 2 / 0"));
    }
}