package car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honuxs")
    public void 자동차_이름이_5글자를_초과할때_에러_반환_여부_테스트(String userInput) {
        assertThatThrownBy(() -> inputParser.parseUserInputByDelimiter(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux")
    public void 자동차_이름들이_모두_5글자_미만일때_정상_반환_여부_테스트(String userInput) {
        assertThat(inputParser.parseUserInputByDelimiter(userInput)).containsExactly("pobi", "crong", "honux");
    }
}
