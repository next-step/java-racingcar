package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarSnapshotTest {

    @Test
    void 생성자_정상적으로_생성된다() {
        CarSnapshot snapshot = new CarSnapshot("자동차", 3);

        assertThat(snapshot.name()).isEqualTo("자동차");
        assertThat(snapshot.distance()).isEqualTo(3);
    }

    @Test
    void 생성자_음수_거리_예외발생() {
        assertThatThrownBy(() -> new CarSnapshot("자동차", -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 거리는 음수일 수 없습니다.");
    }
}
