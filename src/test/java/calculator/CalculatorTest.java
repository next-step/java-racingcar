package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void null_값을_입력할_경우_0을_반환한다() throws Exception{
        // given
        Calculator sutCalculator = new Calculator();
        // when
        int result = sutCalculator.calculate(null);
        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다() throws Exception{
        // given
        Calculator sutCalculator = new Calculator();
        String input = "1001";
        int expectValue = 1001;
        // when
        int sum = sutCalculator.calculate(input);
        // then
        assertThat(sum).isEqualTo(expectValue);
    }

    @Test
    public void 숫자_두개를_컴마_구분자로_입력할_경우_두_숫자의_합을_반환한다()throws Exception{
        // given
        Calculator sutCalculator = new Calculator();
        String input = "1,6";
        int expectValue = 7;
        // when
        int sum = sutCalculator.calculate(input);
        // then
        assertThat(sum).isEqualTo(expectValue);
    }

    @Test
    public void 구분자를_컴마와_콜론을_함께_사용할_수_있다()throws Exception{
        // given
        Calculator sutCalculator = new Calculator();
        String input = "1,7:8";
        int expectValue = 16;
        // when
        int sum = sutCalculator.calculate(input);
        // then
        assertThat(sum).isEqualTo(expectValue);
    }

    @Test
    public void 문자_사이에_커스텀_구분자를_지정할_수_있다() throws Exception{
        // given
        Calculator sutCalculator = new Calculator();
        String input = "//;\n1;2;3";
        int expectValue = 6;
        // when
        int sum = sutCalculator.calculate(input);
        // then
        assertThat(sum).isEqualTo(expectValue);
    }

    @Test
    public void 음수를_전달할_때_RunTimeException_예외가_발생한다() throws Exception{
        // given
        Calculator sutCalculator = new Calculator();
        String input = "1,2,3,-3,a,b";
        String expectValue = "-3";
        // when
        RuntimeException actualException = catchThrowableOfType(
            () -> sutCalculator.calculate(input), RuntimeException.class);
        // then
        assertThat(actualException).hasMessageContaining(expectValue);
    }

}
