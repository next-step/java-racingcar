package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    void 문자열을_기본_구분자로_분리해_리스트로_반환한다() {
        InputParser inputParser = new InputParser();
        List<String> tokens = inputParser.split("1,2:3,4:7");
        assertThat(tokens).hasSize(5);
        assertThat(tokens).contains("1", "2", "3", "4", "7");
    }
    @Test
    void 문자열을_커스텀_구분자로_분리해_리스트로_반환한다() {
        InputParser inputParser = new InputParser();
        List<String> tokens = inputParser.split("//@\n1,2:3@4@7");
        assertThat(tokens).hasSize(5);
        assertThat(tokens).contains("1", "2", "3", "4", "7");
    }
}
