package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"일", "일이삼사오"})
    void 생성자_올바른_값_정상적으로_생성(String input) {
        assertThat(new CarName(input).value()).isEqualTo(input);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @NullSource
    @ValueSource(strings = {"", " "})
    void 생성자_비어있는_이름_예외발생(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어있을 수 없습니다.");
    }

    @Test
    void 생성자_5자_초과_예외발생() {
        assertThatThrownBy(() -> new CarName("일이삼사오육"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
