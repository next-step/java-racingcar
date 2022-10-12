package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TrialCountTest {
    @Test
    @DisplayName("시도 횟수는 1회 이상이다.")
    void create_with_count_over_minimum() {
        assertThatNoException().isThrownBy(() -> new TrialCount(1));
    }

    @Test
    @DisplayName("시도 횟수가 1회보다 작으면 에러가 발생한다.")
    void create_with_count_under_minimum() {
        assertThatThrownBy(() -> new TrialCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1회 이상 입니다.");
    }

    @Test
    @DisplayName("시도 횟수를 줄일 수 있다.")
    void decrease_count() {
        TrialCount totalCount = new TrialCount(2);
        totalCount.decrease();
        assertThat(totalCount).isEqualTo(new TrialCount(1));
    }

    @Test
    @DisplayName("시도 횟수를 줄일 수 있다.")
    void check_remain_count_under_minimum() {
        assertThat(new TrialCount(2).isRemain()).isTrue();
    }

    @Test
    @DisplayName("시도 횟수를 줄일 수 있다.")
    void check_remain_count_over_minimum() {
        TrialCount totalCount = new TrialCount(1);
        totalCount.decrease();
        assertThat(totalCount.isRemain()).isFalse();
    }
}
