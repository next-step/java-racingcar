package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.code.ErrorCodes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorTest {
    @Test
    void plusTest() throws Exception {
        assertThat(Operator.PLUS.operate(1,2)).isEqualTo(3);
    }

    @Test
    void minusTest() throws Exception {
        assertThat(Operator.MINUS.operate(1,2)).isEqualTo(-1);
    }

    @Test
    void multiplyTest() throws Exception {
        assertThat(Operator.MULTIPLY.operate(1, 2)).isEqualTo(2);
    }

    @Test
    void divideTest() throws Exception {
        assertThat(Operator.DIVIDE.operate(4, 2)).isEqualTo(2);
    }

    @Test
    void divideTest_ShouldReturnCustomizedException() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    Operator.DIVIDE.operate(4, 3);
                }).withMessageMatching(ErrorCodes.E00);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void convertStringToOperatorTest(String s, Operator o){
        assertThat(Operator.convertStringToOperator(s)).isEqualTo(o);
    }

    @Test
    void convertStringToOperatorTest_ShouldReturnIllegalArgumentException(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Operator.convertStringToOperator("^");
        });
    }
}
