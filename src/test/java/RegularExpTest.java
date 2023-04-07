import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class RegularExpTest {

    @Test
    void matcherGroupTest() {
        Pattern pattern = Pattern.compile("//(.*)\n");
        Matcher matcher = pattern.matcher("//@\n123123");
        assertThat(matcher.find()).isEqualTo(true);
        assertThat(matcher.group(1)).isEqualTo("@");

        pattern = Pattern.compile("//(.*)\n(1-9+)");
        matcher = pattern.matcher("123123");
        assertThat(matcher.find()).isEqualTo(false);

        pattern = Pattern.compile("//(.*)\n(.*)");
        matcher = pattern.matcher("//;\n1:2:4");
        assertThat(matcher.find()).isEqualTo(true);
        assertThat(matcher.group(1)).isEqualTo(";");
        assertThat(matcher.group(2)).isEqualTo("1:2:4");
    }

    @Test
    void matchesWithRegularExpTest() {
        boolean actual = "\n".matches("\n");
        assertThat(actual).isEqualTo(true);

        actual = "123\n".matches(".+\n");
        assertThat(actual).isEqualTo(true);

        actual = "123\n123123".matches(".+\n.+");
        assertThat(actual).isEqualTo(true);

        actual = "//@\n123123".matches("//.+\n.+");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    void splitWithRegularExpTest() {
        String[] actual = "@\n123123".split("\n");
        assertThat(actual).hasSize(2);
        assertThat(actual).containsExactly("@", "123123");
    }
}