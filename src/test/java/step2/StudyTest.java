package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyTest {
    @DisplayName("split 테스트")
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).hasSize(2);
        assertThat(values).containsExactly("1","2");

        values = "1".split(",");
        assertThat(values).hasSize(1);
        assertThat(values).containsExactly("1");
    }

    @DisplayName("matcher 테스트")
    @Test
    void matcher() {
        String regex = "//(.)\n(.*)";
        String input = "//;\n1;2;3";

        Pattern customPattern = Pattern.compile(regex);
        Matcher m = customPattern.matcher(input);

        assertThat(m.find()).isEqualTo(true);
        assertThat(m.group(1)).isEqualTo(";");
        assertThat(m.group(2)).isEqualTo("1;2;3");


    }

}
