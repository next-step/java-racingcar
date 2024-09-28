package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

}
