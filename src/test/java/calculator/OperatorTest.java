package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("연산자(Operator) 테스트")
public class OperatorTest {

    @DisplayName("2개의 숫자를 더할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,3,4", "3,-5,-2", "0,0,0"})
    void add(int number, int other, int expected) {
        // given
        Operator operator = Operator.ADD;

        // when
        int calculate = operator.calculate(number, other);

        // then
        assertThat(calculate).isEqualTo(expected);
    }

    @DisplayName("2개의 숫자를 뺄 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,3,-2", "3,-5,8", "0,0,0"})
    void subtract(int number, int other, int expected) {
        // given
        Operator operator = Operator.SUBTRACT;

        // when
        int calculate = operator.calculate(number, other);

        // then
        assertThat(calculate).isEqualTo(expected);

    }

    @DisplayName("2개의 숫자를 나눌 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,3,0", "10,3,3"})
    void divide(int number, int other, int expected) {
        // given
        Operator operator = Operator.DIVIDE;

        // when
        int calculate = operator.calculate(number, other);

        // then
        assertThat(calculate).isEqualTo(expected);
    }

    @DisplayName("2개의 숫자를 곱할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,3,3", "3,-5,-15", "0,0,0"})
    void multiply(int number, int other, int expected) {
        // given
        Operator operator = Operator.MULTIPLY;

        // when
        int calculate = operator.calculate(number, other);

        // then
        assertThat(calculate).isEqualTo(expected);
    }

    @DisplayName("숫자(Number) 객체를 통해 계산할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,3,4", "3,-5,-2", "0,0,0"})
    void addByNumber(int value, int otherValue, int expected) {
        // given
        Operator operator = Operator.ADD;
        Number number = Number.valueOf(value);
        Number other = Number.valueOf(otherValue);

        // when
        Number calculate = operator.calculate(number, other);

        // then
        assertThat(calculate).isEqualTo(Number.valueOf(expected));
    }

    @DisplayName("특정 연산자를 찾을 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"+,ADD", "-,SUBTRACT", "/,DIVIDE", "*,MULTIPLY"})
    void symbol(String value, String expected) {
        // when
        Operator operator = Operator.symbol(value);
        System.out.println();

        // then
        assertThat(operator).isSameAs(Operator.valueOf(expected));
    }

    @DisplayName("조건에 맞는 연산자가 없다면 예외처리 한다.")
    @ParameterizedTest
    @ValueSource(strings = "1,&,$")
    void symbolNotFound(String value) {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> Operator.symbol(value));
    }
}
