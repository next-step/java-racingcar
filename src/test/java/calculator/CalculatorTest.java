package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    @Test
    void 문자열이_쉼표를_구분자로_가질경우_각_숫자의_합을_반홚한다() {
        Assertions.assertThat(Calculator.sum("1,2,3")).isEqualTo(6);
    }





}
