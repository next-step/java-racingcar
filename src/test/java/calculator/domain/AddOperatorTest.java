package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class AddOperatorTest {

    private Operator addOperator;

    @BeforeEach
    void setUp() {
        addOperator = new AddOperator();
    }

    @DisplayName("addOperator 테스트")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(value = {
            // x, y, expectedResult
            "     1,   4,      5",
            "    13,  21,     34",
            "121942, 591, 122533"
    })
    void case1(int x, int y, int expectedResult) {
        int result = addOperator.apply(x, y);
        assertThat(result).isEqualTo(expectedResult);
    }
}
