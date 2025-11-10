package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

    @ParameterizedTest(name = "입력값: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    void 생성자_비어있는_이름_예외발생(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어있을 수 없습니다.");
    }
}
