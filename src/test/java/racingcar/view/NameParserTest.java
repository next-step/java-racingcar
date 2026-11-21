package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameParserTest {
    @Test
    @DisplayName("쉼표(,)로 이름을 구분한다")
    void parseNames() {
        List<String> result = NameParser.parse("pobi,crong,honux");

        assertThat(result).containsExactly("pobi", "crong", "honux");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi , crong", " pobi,crong ", "  pobi  ,  crong  "})
    @DisplayName("쉼표 전후의 이름을 둘러싼 공백은 잘라낸다")
    void trimNames(String input) {
        List<String> result = NameParser.parse(input);

        assertThat(result).containsExactly("pobi", "crong");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "pobi,", ",pobi", "pobi,,crong", "pobi, ,crong"})
    @DisplayName(", 사이 공란이나 빈 입력이 들어오면 IllegalArgumentException")
    void throwIllegalArgumentExceptionWithEmptyName(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NameParser.parse(input))
                .withMessage("empty name is not allowed [" + input + "]");
    }
}
