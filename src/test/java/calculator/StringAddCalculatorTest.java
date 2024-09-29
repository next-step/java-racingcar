package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {


    @ParameterizedTest
    @NullSource
    @EmptySource
    void 빈문자열_또는_null(String value) {

        assertThat(StringAddCalculator.splitAndSum(value)).isZero();
        assertThat(StringAddCalculator.splitAndSum(value)).isEqualTo(0);
    }

}
