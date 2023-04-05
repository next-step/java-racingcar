package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    private StringAddCalculator calculator = new StringAddCalculator();

    @Test
    void 문자열이_null인경우_0을_반환한다() {
        final var actual = calculator.splitAndSum(null);

        assertThat(actual).isZero();
    }

    @Test
    void 문자열이_비어있는경우_0을_반환한다() {
        final var actual = calculator.splitAndSum("");

        assertThat(actual).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "3:3", "7:7"}, delimiter = ':')
    void 문자열이_숫자_하나일경우_해당_숫자를_반환한다(String text, int expected) {
        final var actual = calculator.splitAndSum(text);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "4,6:10", "5,5:10"}, delimiter = ':')
    void 두_숫자를_컴마_구분자로_입력하면_두_숫자의_합을_반환한다(String text, int expected) {
        final var actual = calculator.splitAndSum(text);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 컴마_이외의_콜론_구분자가_입력되도_두_숫자의_합을_반환한다() {
        final var actual = calculator.splitAndSum("1,2:3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 문자_입력시_커스텀_구분자를_지정할_수_있다() {
        final var actual = calculator.splitAndSum("//;\n1;2;3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 음수_문자를_전달하면_예외를_던진다() {
        assertThrows(
                RuntimeException.class,
                () -> calculator.splitAndSum("-1,2,3")
        );
    }


}
