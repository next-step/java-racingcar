package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사칙 연산 테스트")
class OperatorTest {

    @Test
    @DisplayName("산술 연산자 문자로 Operator 가져오기")
    void getOperatorTest() {
        assertThat(Operator.of("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.of("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);

        assertThat(Operator.of("++")).isNull();
    }

    @DisplayName("PLUS")
    @ParameterizedTest(name = "{displayName} -> \"({0}) + ({1}) = {2}\"")
    @CsvSource(value = {"7:3:10", "5:2:7", "10:-3:7", "-5:5:0"}, delimiter = ':')
    void plusTest(int num1, int num2, int expected) {
        int actual = Operator.PLUS.exec(num1,num2);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("MINUS")
    @ParameterizedTest(name = "{displayName} -> \"({0}) - ({1}) = {2}\"")
    @CsvSource(value = {"5:2:3", "10:3:7", "10:-5:15" ,"-7:7:-14"}, delimiter = ':')
    void minusTest(int num1, int num2, int expected) {
        int actual = Operator.MINUS.exec(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("MULTIPLY")
    @ParameterizedTest(name = "{displayName} -> \"({0}) * ({1}) = {2}\"")
    @CsvSource(value = {"5:2:10", "10:3:30", "10:-5:-50" ,"-8:-8:64"}, delimiter = ':')
    void multiplyTest(int num1, int num2, int expected) {
        int actual = Operator.MULTIPLY.exec(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("DIVIDE")
    @ParameterizedTest(name = "{displayName} -> \"({0}) * ({1}) = {2}\"")
    @CsvSource(value = {"10:5:2", "10:3:3", "10:-5:-2" ,"-49:7:-7", "5:0:0"}, delimiter = ':')
    void divideTest(int num1, int num2, int expected) {
        int actual = Operator.DIVIDE.exec(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }

}