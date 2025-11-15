package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @Test
    void 라운드_생성시_남은_횟수는_총_횟수와_같다() {
        Round round = new Round(5);

        assertThat(round.getRemaining()).isEqualTo(5);
    }

    @Test
    void 남은_라운드가_있으면_hasRemaining은_true를_반환한다() {
        Round round = new Round(3);

        assertThat(round.hasRemaining()).isTrue();
    }

    @Test
    void decrease를_호출하면_남은_라운드가_감소한다() {
        Round round = new Round(5);

        round.decrease();

        assertThat(round.getRemaining()).isEqualTo(4);
    }

    @Test
    void 모든_라운드를_소진하면_hasRemaining은_false를_반환한다() {
        Round round = new Round(1);

        round.decrease();

        assertThat(round.hasRemaining()).isFalse();
        assertThat(round.getRemaining()).isEqualTo(0);
    }

    @Test
    void 더_이상_진행할_라운드가_없으면_decrease시_예외가_발생한다() {
        Round round = new Round(1);

        round.decrease();

        assertThatThrownBy(() -> round.decrease())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("진행할 라운드가 없습니다");
    }

    @Test
    void 라운드가_1미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Round(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드는 1이상어야 한다");
    }

}
