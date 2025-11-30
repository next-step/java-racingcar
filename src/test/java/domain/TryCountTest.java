package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryCountTest {
    private static final int INIT_TRY_COUNT = 5;
    private TryNumber tryNumber;

    @BeforeEach
    void setUp() {
        tryNumber = new TryNumber(INIT_TRY_COUNT);
    }

    private void increaseTryCount(int increaseCount) {
        for (int i = 1; i <= increaseCount; i++) {
            tryNumber.increase();
        }
    }

    @Test
    public void 종료되지_않은_시도_횟수() {
        increaseTryCount(INIT_TRY_COUNT - 1);
        assertThat(tryNumber.isEnd()).isFalse();
    }

    @Test
    public void 종료된_시도_횟수() {
        increaseTryCount(INIT_TRY_COUNT);
        assertThat(tryNumber.isEnd()).isTrue();
    }
}
