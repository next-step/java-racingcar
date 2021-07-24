package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        String input = "2 + 3";
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minus() {
        String input = "3 - 1";
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiple() {
        String input = "3 * 2";
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide() {
        String input = "6 / 2";
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 사칙연산 이외의 입력이 들어온 경우 예외처리")
    void operator_exception_test() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                String input = "6 a 2";
                int result = stringCalculator.calculate(input);
            }).withMessageMatching("a는 사칙연산자가 아닙니다");
    }

    @Test
    @DisplayName("단일 수식에서 두개 이상의 연산자가 있는 경우도 계산한다")
    void operate_include_two_more_operator() {
        String input = "2 + 3 * 4 / 2";
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(10);
    }
}