package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DivideOperatorTest {

    private Operator divideOperator;

    @BeforeEach
    void setUp() {
        divideOperator = new DivideOperator();
    }

    @DisplayName("divideOperator 테스트")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource(value = {
            // x, y, expectedResult
            "    0,   3,   0",
            "    4,   2,   2",
            "  434,   7,  62",
            "41961, 591,  71"
    })
    void case1(int x, int y, int expectedResult) {
        int result = divideOperator.apply(x, y);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("divideOperator 테스트 : 실패 케이스 -> 제수가 0이라면 에러 발생")
    @Test
    void case2() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            assertThat(divideOperator.apply(3, 0));
        });
    }
}
