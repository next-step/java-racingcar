package learningtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatcherLearningTest {

    private Pattern compile1;
    private Pattern compile2;
    private static final String INPUT1 = "//;\n1;2;3";
    private static final String INPUT2 = "/;\n1;2;3";
    private static final String INPUT3 = "//;?1;2;3";

    @BeforeEach
    void setUp() {
        compile1 = Pattern.compile("//(.)\n(.*)");
        compile2 = Pattern.compile("//(.)\\?(.*)");
    }

    @Test
    void matcher_find() {
        Matcher matcher = compile1.matcher(INPUT1);
        assertThat(matcher.find()).isTrue();

        Matcher matcher2 = compile1.matcher(INPUT2);
        assertThat(matcher2.find()).isFalse();
    }

    @Test
    void matcher_group() {
        Matcher matcher = compile2.matcher(INPUT3);
        if (matcher.find()) {
            assertThat(matcher.group()).isEqualTo(INPUT3);
            assertThat(matcher.group(1)).isEqualTo(";");
            assertThat(matcher.group(2)).isEqualTo("1;2;3");
        }
    }
}
