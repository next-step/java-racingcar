package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {


    @Test
    void 문자열이_쉼표를_구분자로_가질경우_각_숫자의_합을_반홚한다() {
        Assertions.assertThat(Calculator.sum("1,2,3")).isEqualTo(6);
    }


    @Test
    void 문자열이_콜론을_구분자로_가질경우_각_숫자의_합을_반환한다() {
        Assertions.assertThat(Calculator.sum("1:2:3")).isEqualTo(6);
    }


    @ParameterizedTest
    @CsvSource({"'1,2', 3", "'1,2,3', 6", "'1:2:3', 6"})
    void 쉼표_또는_콜론을_구분자로_가지는_문자열의_합을_구한다(String input, int expected) {
        Assertions.assertThat(Calculator.sum(input)).isEqualTo(expected);
    }



    @Test
    void 빈_문자열일_경우_0을_반환한다() {
        Assertions.assertThat(Calculator.sum("")).isEqualTo(0);
    }




}
