package racinggame.winner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCountTest {

    @Test
    @DisplayName("경기 횟수는 0 이상이어야 한다.")
    void 경기_횟수() {
        assertThatThrownBy(() -> new RacingCount(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경기 횟수보다 많은 시도를 할 수 없다.")
    void 경기_횟수_초과() {
        RacingCount sut = new RacingCount(1);
        sut.decrease();
        assertThatThrownBy(sut::decrease)
            .isInstanceOf(IllegalStateException.class);
    }
}