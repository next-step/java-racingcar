package step3.racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarEngineTest {

    @Test
    @DisplayName("RacingCarEngine::canRun() - GO")
    void givenAlwaysGoThreshold_whenRacingCarEngineCanRun_thenTrue() {
        // given
        int threshold = 0;

        // when
        RacingCarEngine carEngine = new RacingCarEngine(threshold);

        // then
        assertThat(carEngine.canRun()).isTrue();
    }

    @Test
    @DisplayName("RacingCarEngine::canRun() - STOP")
    void givenAlwaysStopThreshold_whenRacingCarEngineCanRun_thenFalse() {
        // given
        int threshold = 9;

        // when
        RacingCarEngine carEngine = new RacingCarEngine(threshold);

        // then
        assertThat(carEngine.canRun()).isFalse();
    }

}
