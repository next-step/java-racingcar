package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("공백 단위로 문자열을 분리한다.")
    void splitWithSpace(String input) {
        Elements result = stringCalculator.splitWithSpace(input);
        assertThat(result).isEqualTo(new Elements(new String[]{"2", "+", "3", "*", "4", "/", "2"}));
    }
}
