package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RunCountTest {

    @Test
    @DisplayName("시도 횟수가 음수이면 에러가 발생한다.")
    void create() {
        assertThatThrownBy(() -> new RunCount(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 남아있으면 true를 반환한다.")
    void isRemaining() {
        assertThat(new RunCount(1).isRemaining()).isTrue();
        assertThat(new RunCount(0).isRemaining()).isFalse();
    }

    @Test
    @DisplayName("시도 횟수가 남아있지 않은 상태에서 횟수를 감소시키면, 에러가 발생한다.")
    void failToDecrease() {
        assertThatThrownBy(() -> new RunCount(0).decrease()).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("시도 횟수를 감소시킨다.")
    void decrease() {
        RunCount runCount = new RunCount(1);
        runCount.decrease();
        assertThat(runCount).isEqualTo(new RunCount(0));
    }

}