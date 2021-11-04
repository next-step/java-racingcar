package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private StringCalculator calculator ;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }


    @DisplayName("간단한 문자열 테스트")
    @ParameterizedTest
    @CsvSource(value =
            {"3 + 7 * 2 / 2 : 10",
            "10 * 3 + 6 / 6 : 6"},
            delimiter = ':')
   public void operatorTest(String strInputData, String strResult) {
        assertThat(calculator.execute(strInputData)).isEqualTo(strResult);
    }

    @DisplayName("공백을 입력했을 때 오류 테스트")
    @Test
    public void blankExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculator.execute("null"));
    }

    @DisplayName("연산자 표시가 잘못 되어 있을 때 오류 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4 & 8", "5 ^ 3"})
    public void operationExceptionTest(String strInputData) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculator.execute(strInputData));
    }

    @DisplayName("나누기 결과가 정수가 아닐 때 오류 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4 / 5"})
    public void divideExceptionTest(String strInputData) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculator.execute(strInputData));
    }
}
