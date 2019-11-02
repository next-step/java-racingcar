package step2.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void parse_input_as_integer_list() {
        String rawInput1 = "0,1:2";
        String rawInput2 = "//&\\n0&1&2";
        Parser sut1 = new Parser(rawInput1);
        Parser sut2 = new Parser(rawInput2);

        assertThat(sut1.parse()).containsExactly(0, 1, 2);
        assertThat(sut2.parse()).containsExactly(0, 1, 2);
    }

    @Test
    void split_default_delimiter() {
        String rawInput = "0,1:2";
        Parser sut = new Parser(rawInput);
        assertThat(sut.parse().size()).isEqualTo(3);
    }

    @Test
    void split_custom_delimiter() {
        String rawInput = "//&\\n1&2&3";
        Parser sut = new Parser(rawInput);
        assertThat(sut.parse().size()).isEqualTo(3);
    }

    @Test
    void check_custom_delimiter_works() {
        String rawInput = "//&\\n1&2&3";
        String customDelimiter = "^//.+\\\\n";
        Pattern pattern = Pattern.compile(customDelimiter);
        assertThat(pattern.matcher(rawInput).find()).isTrue();

        assertThat(pattern.matcher(rawInput).replaceAll("")).isEqualTo("1&2&3");
    }

    @Test
    void extract_custom_delimiter() {
        String rawInput = "//&&&\\n1&&&2&&&3";

        assertThat(rawInput.substring(2, rawInput.indexOf("\\n"))).isEqualTo("&&&");
    }

    @Test
    void matcher_replace_works() {
        String rawInput = "//&\\n1&2&3";
        String customDelimiter = "^//.+\\\\n";
        Pattern pattern = Pattern.compile(customDelimiter);
        assertThat(pattern.matcher(rawInput).find()).isTrue();

        assertThat(pattern.matcher(rawInput).replaceAll("")).isEqualTo("1&2&3");
    }
}
