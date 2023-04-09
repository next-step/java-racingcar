package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class MatcherTest {
    @Test
    void matcher() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher("//;\n 1;2;3");
        assertThat(m.find()).isTrue();
    }
}
