package racing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputViewTest {

    public static final Pattern PATTERN = Pattern.compile("[1-9]\\d*");

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10", "152"})
    public void inputNumberTest(String input) {
        assertTrue(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    public void inputZeroTest(String input) {
        assertFalse(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-15", "-2352"})
    public void inputNegativeNumberTest(String input) {
        assertFalse(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "English"})
    public void inputNotNumberTest(String input) {
        assertFalse(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void isBlankTest(String input) {
        assertFalse(isMatch(input));
    }

    private static boolean isMatch(String input) {
        Matcher matcher = PATTERN.matcher(input);
        return matcher.matches();
    }
}
