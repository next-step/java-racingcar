package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindDelimiterTest {

    private static final String DEFAULT_DELIMITER;
    private static final String CUSTOM_DELIMITER;
    private static final Pattern CUSTOM_DELIMITER_PATTERN;

    static {
        DEFAULT_DELIMITER = ":|,";
        CUSTOM_DELIMITER = "//(.*)\n(.*)";
        CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    }

    @Test
    void test() {
        String input = "//@\n1@-2@4";

        String delimiter = findDelimiter(input);
        String[] split = input.split(delimiter);

        // failed
        assertThat(split).containsExactly("1", "-2", "4");
    }

    private static String findDelimiter(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            return DEFAULT_DELIMITER + '|' + m.group(1);
        }
        return DEFAULT_DELIMITER;
    }
}
