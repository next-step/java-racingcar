package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class EquationParserTest {

    private EquationParser parser;

    @BeforeEach
    void setUp() {
        parser = new EquationParser();
    }

    @DisplayName("입력값이 null 또는 공백일 경우 IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void nullOrEmptyInput_Then_IllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> parser.parse(input));
    }
}
