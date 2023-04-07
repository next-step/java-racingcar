package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatcherTest {

    @Test
    void 정규표현식() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//;\n1;2;3");
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(1)).isEqualTo(";");
        assertThat(matcher.group(2)).isEqualTo("1;2;3");
    }

}
