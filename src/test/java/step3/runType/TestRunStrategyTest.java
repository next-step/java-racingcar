package step3.runType;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestRunStrategyTest {

    @Test
    @DisplayName("'테스트' 운행방식은 항상 1만큼 전진할 수 있다.")
    void normal_run_strategy() {
        TestRunStrategy strategy = new TestRunStrategy();
        int progressDistance = strategy.run();
        assertThat(progressDistance).isEqualTo(TestRunStrategy.NORMAL_PROGRESS_DISTANCE);
    }
}