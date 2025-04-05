package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class TryNumTest {
    @Test
    void isEnd() {
        final TryNum tryNum = new TryNum(1);
        tryNum.minusOne();
        assertThat(tryNum.isEnd()).isEqualTo(true);
        assertThat(new TryNum(1).isEnd()).isEqualTo(false);
    }

    @Test
    void minusOne() {
        final TryNum tryNum = new TryNum(2);
        tryNum.minusOne();
        assertThat(tryNum).isEqualTo(new TryNum(1));
    }

    @Test
    void inputZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> new TryNum(0));
    }
}