package calculator.operator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringOperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", ":false"}, delimiter = ':')
    public void isNotBlank(String value, boolean expected) {
        MessageOperator result = new MessageOperator(value);
        assertThat(result.isNotBlank()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3,4/1,2,3,4", "1,2/1,2"}, delimiter = '/')
    public void splitMessage(String value, String expected) {
        MessageOperator result = new MessageOperator(value);
        String[] a = result.split();
        assertThat(result.split()).isEqualTo(expected.split(","));
    }
}