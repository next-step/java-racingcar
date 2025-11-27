package racingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberTest {

    @Test
    @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다")
    void tryNumberLessThanOne_throwsException() {
        assertThatThrownBy(() -> new TryNumber(0))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new TryNumber(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("canPlayMore는 playedCount가 value보다 작을 때만 true를 반환한다")
    void canPlayMore_behavesCorrectly() {
        TryNumber tryNumber = new TryNumber(3);

        assertThat(tryNumber.canPlayMore(0)).isTrue();
        assertThat(tryNumber.canPlayMore(2)).isTrue();
        assertThat(tryNumber.canPlayMore(3)).isFalse();
        assertThat(tryNumber.canPlayMore(4)).isFalse();
    }
}
