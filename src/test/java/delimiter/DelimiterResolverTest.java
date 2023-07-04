package delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import caculator.delimiter.DelimiterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterResolverTest {

    @Test
    @DisplayName("커스텀 구분자가 없는 경우")
    void nonCustomDelimiterTest() {
        String text = "1,2:3";
        String[] resolved = DelimiterResolver.resolve(text);
        assertThat(resolved[0]).isEqualTo(DelimiterResolver.BASIC_DELIMITER);
        assertThat(resolved[1]).isEqualTo(text);
    }

    @Test
    @DisplayName("커스텀 구분자가 있는 경우")
    void customDelimiterTest() {
        String text = "//;\n1;2;3";
        String[] resolved = DelimiterResolver.resolve(text);
        assertThat(resolved[0]).isEqualTo(DelimiterResolver.BASIC_DELIMITER + "|;");
        assertThat(resolved[1]).isEqualTo("1;2;3");
    }

}