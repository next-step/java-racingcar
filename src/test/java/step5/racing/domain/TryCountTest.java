package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    void 시도할_회수가_0보다_작을_때_예외가_발생한다() {
        assertThatThrownBy(() -> new TryCount(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도를_할_때_1씩_감소된_시도_회수가_반환된다() {
        TryCount tryCount = new TryCount(1);

        assertThat(tryCount.decrease()).isEqualTo(new TryCount(0));
    }

    @Test
    void 시도가_끝나면_종료_확인_메서드_호출시_true를_반환한다() {
        TryCount tryCount = new TryCount(0);

        assertThat(tryCount.isEnd()).isTrue();
    }
}
