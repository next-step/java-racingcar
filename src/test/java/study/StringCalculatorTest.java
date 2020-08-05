package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    void stringCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.stringCheck(input);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "!", "@", "#", "$", "%", "^", "&", "(", ")"})
    void calculationCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculationCheck(input);
        });
    }

}
