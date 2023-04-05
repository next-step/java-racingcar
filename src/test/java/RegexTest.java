import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexTest {

    @DisplayName("정규식 테스트")
    @Test
    void regex_test() {
        String input = "//;\n1;-2.3";
        String pattern = "//(.)\n(.+)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(input);
        if (matcher.find()) {
            assertThat(matcher.group(1))
                .isEqualTo(";");

            assertThat(matcher.group(2))
                .isEqualTo("1;-2.3");
        }
    }
}
