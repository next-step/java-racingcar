package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    void 본문을_구분자로_분리해_리스트로_반환한다() {
        InputParser inputParser = new InputParser("//@\n1,2:3@4@7");
        List<String> tokens = inputParser.getTokens();
        assertThat(tokens).hasSize(5);
        assertThat(tokens).contains("1", "2", "3", "4", "7");
    }
}
