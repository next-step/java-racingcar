import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {
    private Calculator c;

    @BeforeEach
    void setUp() {
        c = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("사칙 연산 간단식 테스트")
    @MethodSource
    void calculateFourRule_simpleExpression(String expStr, int resultExpected) {
        Expression e = new Expression(expStr);
        int result = c.calculate(e);

        assertThat(result).isEqualTo(resultExpected);
    }

    @Test
    @DisplayName("사칙 연산 복잡식 테스트")
    @MethodSource
    void caculateFourRule_complicatedExpression() {
        String expStr = "2 + 3 * 4 / 2";
        int resultExpected = 10;

        Expression e = new Expression(expStr);
        int result = c.calculate(e);

        assertThat(result).isEqualTo(resultExpected);
    }

    static Stream<Arguments> calculateFourRule_simpleExpression() {
        return Stream.of(
                arguments("2 + 4", 6),
                arguments("3 - 2", 1),
                arguments("2 * 3", 6),
                arguments("4 / 2", 2)
        );
    }
}
