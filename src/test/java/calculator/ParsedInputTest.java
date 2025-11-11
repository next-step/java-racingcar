package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ParsedInputTest {

    @Test
    void 본문을_구분자로_분리해_리스트로_반환한다() {
        ParsedInput parsedInput = new ParsedInput(",|:|@", "1,2:3@4@7");
        List<String> contents = parsedInput.split();
        assertThat(contents).hasSize(5);
        assertThat(contents).contains("1", "2", "3", "4", "7");
    }
}
