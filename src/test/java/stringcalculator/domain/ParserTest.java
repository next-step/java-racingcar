package stringcalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    @Test
    void 생성() {
        SimpleParser parser = new SimpleParser("1 + 2");
        assertThat(parser).isEqualTo(new SimpleParser("1 + 2"));
    }

    @Test
    void parse() {
        SimpleParser parser = new SimpleParser("1 + 2");
        Expression expression = parser.parse();
        assertThat(expression.operate()).isEqualTo(3);
    }
}
