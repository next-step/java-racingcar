package com.seok2.calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    static Stream<String> emptyStrings() {
        return Stream.of("", "   ", "         ", null);
    }

    @ParameterizedTest
    @MethodSource("emptyStrings")
    void isEmpty(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.isEmpty(input));
    }
}