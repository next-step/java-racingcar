package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    void 숫자_하나를_전달하면_값을_그대로_리턴한다() {
        //given
        String singleNumber = "3";
        //then
        assertThat(Calculator.calculate(singleNumber)).isEqualTo(3);
    }

    @Test
    void 숫자_두개를_콤마_세미콜론과_함께_전달하면_두_숫자를_더한다() {
        //given
        String twoNumberWithDelimiter = "1;2";
        //then
        assertThat(Calculator.calculate(twoNumberWithDelimiter)).isEqualTo(3);
    }

    @Test
    void 숫자_여러개를_콤마_세미콜론과_함께_전달하면_여러_숫자를_더한다() {
        //given
        String twoNumberWithDelimiter = "1;2;50,2";
        //then
        assertThat(Calculator.calculate(twoNumberWithDelimiter)).isEqualTo(55);
    }

    @Test
    void 숫자이외의_값을_전달하면_RuntimeException_반환() {
        //given
        String notNumber = "문자";
        //then
        assertThatThrownBy(() -> {
            Calculator.calculate(notNumber);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수를_전달하면_RuntimeException_반환() {
        //given
        String negativeNumber = "1;-1";
        //then
        assertThatThrownBy(() -> {
            Calculator.calculate(negativeNumber);
        }).isInstanceOf(RuntimeException.class);
    }
}
