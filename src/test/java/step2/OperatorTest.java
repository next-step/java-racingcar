package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "$", "1"})
    void UnSupportedCharacterTest(String strOperator) throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.from(strOperator))
                .withMessageContaining("지원하지않는 연산자");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3:+", "3:2:1:-", "4:5:20:*", "10:5:2:/"}, delimiter = ':')
    void operationTest(int a, int b, int expected, String strOperator) throws Exception {
        //given
        Operator operator = Operator.from(strOperator);

        //when
        int result = operator.operate(a, b);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
