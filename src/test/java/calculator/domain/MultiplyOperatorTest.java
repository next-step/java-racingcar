package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplyOperatorTest {

    private Operator multiplyOperator;

    @BeforeEach
    void setUp() {
        multiplyOperator = new MultiplyOperator();
    }

    @DisplayName("multiplyOperator 테스트")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource(value = {
            // x, y, expectedResult
            "   1,   4,      4",
            " 133,   7,    931",
            "1212, 591, 716292"
    })
    void case1(int x, int y, int expectedResult) {
        int result = multiplyOperator.apply(x, y);
        assertThat(result).isEqualTo(expectedResult);
    }
}
