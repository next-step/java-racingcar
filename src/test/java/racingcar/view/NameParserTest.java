package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameParserTest {
    @Test
    @DisplayName("쉼표를 기준으로 이름을 구분한다")
    void splitByComma() {
        assertThat(NameParser.parse("pobi,crong,honux"))
                .containsExactly(new CarName("pobi"), new CarName("crong"), new CarName("honux"));
    }

    @Test
    @DisplayName("이름이 하나면 하나만 반환한다")
    void singleName() {
        assertThat(NameParser.parse("pobi")).containsExactly(new CarName("pobi"));
    }

    @Test
    @DisplayName("쉼표 전후의 공백은 잘라낸다")
    void trimAroundComma() {
        assertThat(NameParser.parse(" pobi , crong ,honux "))
                .containsExactly(new CarName("pobi"), new CarName("crong"), new CarName("honux"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    @DisplayName("입력이 null이거나 비어 있으면 IllegalArgumentException")
    void throwsExceptionWhenInputIsEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> NameParser.parse(input))
                .withMessage("car names are required");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,,crong", "pobi,", ",pobi", "pobi, ,crong"})
    @DisplayName("쉼표 사이에 이름이 없으면 IllegalArgumentException")
    void throwsExceptionWhenNameBetweenCommasIsEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> NameParser.parse(input));
    }
}
