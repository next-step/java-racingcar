package study.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorTest {
    private Operator operator;

    @BeforeEach
    void setUp() {
        operator = new Operator();
    }

    @DisplayName("덧셈을 테스트 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1,2", "99999999,99999999,199999998", "-1,-1,-2", "-100,100,0", "0,0,0"})
    void plus(int leftSide, int rightSide, int expect) {
        assertThat(operator.plus(leftSide, rightSide)).isEqualTo(expect);
    }

    @DisplayName("뺄셈을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value={"5,3,2", "3,5,-2", "-100,100,-200", "0,0,0"})
    void minus(int leftSide, int rightSide, int expect) {
        assertThat(operator.minus(leftSide, rightSide)).isEqualTo(expect);
    }

    @DisplayName("나눗셈을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value={"6,3,2", "-6,3,-2", "-6,-3,2", "2,5,0", "5,2,2", "0,2,0"})
    void divide(int leftSide, int rightSide, int expect) {
        assertThat(operator.divide(leftSide, rightSide)).isEqualTo(expect);
    }

    @DisplayName("나눗셈 오류를 테스트한다.")
    @Test
    void divideError() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            operator.divide(2, 0);
        });
    }

    @DisplayName("곱셈을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value={"1,1,1", "5,6,30", "-3,6,-18", "-3,-6,18", "3,0,0", "0,0,0"})
    void multiply(int leftSide, int rightSide, int expect) {
        assertThat(operator.multiply(leftSide, rightSide)).isEqualTo(expect);
    }
}
