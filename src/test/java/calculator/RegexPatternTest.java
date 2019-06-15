package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static calculator.StringCalculator.REGEX_PATTERN;
import static org.assertj.core.api.Assertions.assertThat;

public class RegexPatternTest {

    @ParameterizedTest
    @ValueSource(strings = {"1",
                            "1 + 20",
                            "2 + 20 - 2 / 2 * 3"})
    void regexSuccess(String text) {
        Pattern pattern = getPattern();
        assertThat(pattern.matcher(text).find()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + ",
                            "1 + 10 +",
                            "1+20/20"})
    void regexFail(String text) {
        Pattern pattern = getPattern();
        assertThat(pattern.matcher(text).find()).isFalse();
    }

    private Pattern getPattern() {
        return Pattern.compile(REGEX_PATTERN);
    }
}
