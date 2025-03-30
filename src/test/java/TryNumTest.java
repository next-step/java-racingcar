import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TryNumTest {
    @Test
    void isEnd() {
        assertThat(new TryNum(0).isEnd()).isEqualTo(true);
        assertThat(new TryNum(1).isEnd()).isEqualTo(false);
    }

    @Test
    void minusOne() {
        final TryNum tryNum = new TryNum(1);
        tryNum.minusOne();
        assertThat(tryNum).isEqualTo(new TryNum(0));
    }
}