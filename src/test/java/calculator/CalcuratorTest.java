package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CalcuratorTest {

    Calcurator calcurator;

    @BeforeEach
    public void setup() {
        calcurator = new Calcurator();
    }

    @DisplayName(" add 함수 테스트 ")
    @ParameterizedTest
    @CsvSource(value = {"5,3,8", "4,2,6", "2,1,3"}, delimiter = ',')
    public void addTest(String first, String second, String result) {
        assertThat(calcurator.add(toInt(first), toInt(second))).isEqualTo(toInt(result));
    }

    @DisplayName(" substract 함수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5,3,2", "4,2,2", "2,1,1"}, delimiter = ',')
    public void substractTest(String first, String second, String result) {
        assertThat(calcurator.subtract(toInt(first), toInt(second))).isEqualTo(toInt(result));
    }

    @DisplayName(" multiply 함수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5,3,15", "4,2,8", "2,1,2"}, delimiter = ',')
    public void multiplyTest(String first, String second, String result) {
        assertThat(calcurator.multiply(toInt(first), toInt(second))).isEqualTo(toInt(result));
    }

    @DisplayName(" divide 함수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5,3,1", "4,2,2", "2,1,2"}, delimiter = ',')
    public void divideTest(String first, String second, String result) {
        assertThat(calcurator.divide(toInt(first), toInt(second))).isEqualTo(toInt(result));
    }

    public int toInt(String value) {
        return Integer.parseInt(value);
    }

    @DisplayName(" 값이 빈 값이 입력될 경우 ")
    @Test
    public void blankExceptionTest() {
        String expression = "2 +   * 5";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            int i = calcurator.calcurateString(expression);
        });
    }

    @DisplayName(" String Expression Test")
    @Test
    void StringExpressionTest() {
        assertThat(calcurator.calcurateString("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @DisplayName(" operation Exception Test")
    @Test
    void operatorExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calcurator.calcurate(2, '8', 6);
        });
    }


}