package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    void 시도횟수가_0보다_작을_때는_예외가_발생한다() {
        assertThatThrownBy(() -> new TryCount(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 마지막_시도일_때는_true를_반환한다() {
        TryCount tryCount = new TryCount(0);

        assertThat(tryCount.isEnd()).isTrue();
    }

    @Test
    void 마지막_시도가_아닐_때는_false를_반환한다() {
        TryCount tryCount = new TryCount(3);

        assertThat(tryCount.isEnd()).isFalse();
    }

    @Test
    void decrase를_하게_되면_1을_감소한_값이_반환된다() {
        TryCount tryCount = new TryCount(3);

        assertThat(tryCount.decrease()).isEqualTo(new TryCount(2));
    }
}
