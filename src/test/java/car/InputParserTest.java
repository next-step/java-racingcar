package car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    private InputParser inputParser = new InputParser();

    @ParameterizedTest
    @ValueSource(strings = "pobi")
    public void 자동차_이름_1개일때_파싱_테스트(String userInput) {
        assertThat(inputParser.parseUserInputByDelimiter(userInput)).containsExactly("pobi");
    }

    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux")
    public void 자동차_이름_여러개일때_파싱_테스트(String userInput) {
        assertThat(inputParser.parseUserInputByDelimiter(userInput)).containsExactly("pobi", "crong", "honux");
    }
}
