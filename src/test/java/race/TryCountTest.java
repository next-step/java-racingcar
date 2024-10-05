package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    void 생성() {
        TryCount tryCount = new TryCount(3);

        assertThat(tryCount).isEqualTo(new TryCount(3));
    }

    @Test
    void TryCount는_음수가_아니다() {
        assertThatThrownBy(() -> new TryCount(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("TryCount is not allowed minus number or zero");
    }

    @Test
    void TryCount는_0이_아니다() {
        assertThatThrownBy(() -> new TryCount(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("TryCount is not allowed minus number or zero");
    }

    @Test
    void decrease를_실행하면_값이_1_줄어든다() {
        TryCount tryCount = new TryCount(3);

        TryCount result = tryCount.decrease();

        assertThat(result).isEqualTo(new TryCount(2));
    }

    @Test
    void isZero를_실행하면_양수인지_확인한다() {
        TryCount tryCount = new TryCount(1);

        boolean result = tryCount.isPlus();

        assertThat(result).isTrue();
    }
}
