package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalcOperatorTest {

    @CsvSource(value = {"1:1:2", "10:1:11", "5:5:10"}, delimiter = ':')
    @ParameterizedTest(name = "{0} + {1}은 {2}이 반환되어야한다")
    void addTest(int given1, int given2, int result) {
        // given
        CalcOperator add = CalcOperator.ADD;
        // when
        int calc = add.calc(given1, given2);
        // then
        assertThat(calc).isEqualTo(result);
    }

    @CsvSource(value = {"1:1:0", "10:1:9", "5:6:-1"}, delimiter = ':')
    @ParameterizedTest(name = "{0} - {1}은 {2}이 반환되어야한다")
    void minusTest(int given1, int given2, int result) {
        // given
        CalcOperator minus = CalcOperator.MINUS;
        // when
        int calc = minus.calc(given1, given2);
        // then
        assertThat(calc).isEqualTo(result);
    }

    @CsvSource(value = {"1:1:1", "10:1:10", "5:5:25"}, delimiter = ':')
    @ParameterizedTest(name = "{0} * {1}은 {2}ㅁㅇ 반환되어야한다")
    void multiTest(int given1, int given2, int result) {
        // given
        CalcOperator multi = CalcOperator.MULTI;
        // when
        int calc = multi.calc(given1, given2);
        // then
        assertThat(calc).isEqualTo(result);
    }

    @CsvSource(value = {"1:1:1", "10:2:5", "15:5:3"}, delimiter = ':')
    @ParameterizedTest(name = "{0} / {1}은 {2}이 반환되어야한다")
    void divideTest(int given1, int given2, int result) {
        // given
        CalcOperator divide = CalcOperator.DIVIDE;
        // when
        int calc = divide.calc(given1, given2);
        // then
        assertThat(calc).isEqualTo(result);
    }

    @DisplayName("null 값이나 빈 공백문자가 들어오면 IllegalArgumentException 발생.")
    @Test
    void throwIllegalArgumentExceptionWhenInputIsNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calc(null));

        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calc(""));
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 발생")
    @Test
    void throwIllegalArgumentExceptionWhenBadSign() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calc("1 + 2 = 3"));
    }

    @DisplayName("올바른 사칙기호로 find 하면 알맞은 calcOperator가 찾아진다")
    @Test
    void findCalcOperatorWithOperator() {
        // Given
        // When
        CalcOperator addCalcOperator = CalcOperator.find("+");
        CalcOperator minusCalcOperator = CalcOperator.find("-");
        CalcOperator multiCalcOperator = CalcOperator.find("*");
        CalcOperator divideCalcOperator = CalcOperator.find("/");
        // Then
        assertThat(addCalcOperator).isEqualTo(CalcOperator.ADD);
        assertThat(minusCalcOperator).isEqualTo(CalcOperator.MINUS);
        assertThat(multiCalcOperator).isEqualTo(CalcOperator.MULTI);
        assertThat(divideCalcOperator).isEqualTo(CalcOperator.DIVIDE);

    }

    @DisplayName("존재하지 않는 사칙기호로 find를하면 illegalArgumentException을 던진다")
    @Test
    void throwIllegalArgumentExceptionWhenFindWithBadOperator() {
        // Given
        // When
        // Then
        assertThatIllegalArgumentException().isThrownBy(() -> CalcOperator.find("="));
    }

}