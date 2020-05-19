package step2;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.Operator;
import step2.OperatorMapper;

class OperatorMapperTest {

    @ParameterizedTest
    @CsvSource({ "+, PLUS", "-, MINUS", "*, MULTIPLY", "/, DIVISION" })
    void getOperator(String symbol, Operator operator) {
        assertThat(OperatorMapper.getInstance().getOperator(symbol)).isEqualTo(operator);
    }

}
