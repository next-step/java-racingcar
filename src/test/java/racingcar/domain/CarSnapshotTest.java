package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarSnapshotTest {

    @ParameterizedTest(name = "입력값: {0}")
    @NullSource
    @ValueSource(strings = {"", " "})
    void 생성자_비어있는_이름_예외발생(String input) {
        assertThatThrownBy(() -> new CarSnapshot(input, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어있을 수 없습니다.");
    }

    @Test
    void 생성자_음수_거리_예외발생() {
        assertThatThrownBy(() -> new CarSnapshot("자동차", -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 거리는 음수일 수 없습니다.");
    }
}
