package step3.runType;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HighSpeedRunStrategyTest {

    @Test
    @DisplayName("'초스피드' 운행방식은 언제나 0 혹은 2사이만 전진할 수 있다.")
    void high_speed_strategy() {
        HighSpeedRunStrategy strategy = new HighSpeedRunStrategy();
        int progressDistance = strategy.run();
        assertThat(progressDistance).isBetween(
            HighSpeedRunStrategy.NO_PROGRESS_DISTANCE,
            HighSpeedRunStrategy.HIGH_SPEED_PROGRESS_DISTANCE);
    }
}