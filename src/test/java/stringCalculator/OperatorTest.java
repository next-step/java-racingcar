package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    private Operator operator;

    @BeforeEach
    void setUp() {
        this.operator = new Operator();
    }

    @DisplayName("지원하는 연산자에 대한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+:true", "-:true", "*:true", "/:true", "&:false"}, delimiter = ':')
    void supportOperator(String input, boolean expected) {
        assertThat(operator.isValidOperator(input)).isEqualTo(expected);
    }

    @DisplayName("연산 테스트")
    @Test
    void calculateTest() {
        int expected = 3;
        int result = operator.calculateWithOperator(1, "+", 2);

        assertThat(result).isEqualTo(expected);

    }

}
