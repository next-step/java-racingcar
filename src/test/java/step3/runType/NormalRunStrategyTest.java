package step3.runType;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NormalRunStrategyTest {


    @Test
    @DisplayName("'정상' 운행방식은 언제나 0 혹은 1사이만 전진할 수 있다.")
    void normal_run_strategy() {
        NormalRunStrategy strategy = new NormalRunStrategy();
        int progressDistance = strategy.run();
        assertThat(progressDistance).isBetween(
            NormalRunStrategy.NO_PROGRESS_DISTANCE,
            NormalRunStrategy.NORMAL_PROGRESS_DISTANCE);
    }

}