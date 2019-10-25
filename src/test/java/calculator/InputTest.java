package calculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputTest {

    InputValidator iv;

    @BeforeEach
    void setUp() {
        iv = new InputValidator();
    }

    @ParameterizedTest
    @NullSource
    void nullTest(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            iv.validate(inputStr);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    void emptyStringTest(String inputStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           iv.validate(inputStr);
        });
    }
}
