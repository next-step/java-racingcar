package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractOperatorTest {

    private Operator subtractOperator;

    @BeforeEach
    void setUp() {
        subtractOperator = new SubtractOperator();
    }

    @DisplayName("subtractOperator 테스트")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource(value = {
            // x, y, expectedResult
            "     1,   4,     -3",
            "   133,   7,    126",
            "121942, 591, 121351"
    })
    void case1(int x, int y, int expectedResult) {
        int result = subtractOperator.apply(x, y);
        assertThat(result).isEqualTo(expectedResult);
    }
}
