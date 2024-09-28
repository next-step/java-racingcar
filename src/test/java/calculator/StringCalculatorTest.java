package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   "})
    void 빈_문자열_입력_시_0_반환(final String input){
        int result = StringCalculator.sum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "45678912"})
    void 숫자만_입력시_숫자_반환(final String input ){
        int result = StringCalculator.sum(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }


    @ParameterizedTest
    @CsvSource(value = {
            "1,2=3",
            "4,5=9",
            "1,2,=3",
            "4,5,=9",
            "1,=1"
    }, delimiter = '=')
    void 쉼표로_구분된_두_숫자_입력_시_합_반환(final String input, final Integer result){
        StringCalculator.spiltAndSum(input);
    }

}
