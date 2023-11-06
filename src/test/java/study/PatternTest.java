package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PatternTest {

    @Test
    @DisplayName("커스텀 구분자를 생성할 수 있다.")
    void custom_regex() {
        // given
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        String text = "//%\n3%4%5";

        // when
        Matcher matcher = pattern.matcher(text);
        boolean result = matcher.find();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 값들을 알 수 있다.")
    void custom_regex_split() {
        String text = "//abc\n1abc2abc3";
        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(text);

        String[] result = new String[]{};
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            result = matcher.group(2).split(customDelimiter);
        }

        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }
}
