package calculator;

import caculator.StringCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void splitAntSum_null_또는_빈문자(String input) {
        // when
        int result = StringCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(0);
    }
}
