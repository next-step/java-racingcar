package step2.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void split_single_delimiter() {
        String rawInput = "0,1:2";
        Parser sut = new Parser(rawInput);
        assertThat(sut.parse(":").size()).isEqualTo(2);
    }

    @Test
    void split_multiple_delimiter() {
        String rawInput = "0,1:2";
        Parser sut = new Parser(rawInput);
        assertThat(sut.parse("\\:|\\,").size()).isEqualTo(3);
    }
}
