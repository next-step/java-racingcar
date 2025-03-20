package step4.racingcar2.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingcar.model.RacingCarEngine;

public class RacingCarEngineTest {

    @Test
    @DisplayName("RacingCarEngine::canRun() - GO")
    void givenAlwaysGoThreshold_whenRacingCarEngineCanRun_thenTrue() {
        // given
        int threshold = 0;

        // when
        step3.racingcar.model.RacingCarEngine carEngine = new step3.racingcar.model.RacingCarEngine(threshold);

        // then
        assertThat(carEngine.canRun()).isTrue();
    }

    @Test
    @DisplayName("RacingCarEngine::canRun() - STOP")
    void givenAlwaysStopThreshold_whenRacingCarEngineCanRun_thenFalse() {
        // given
        int threshold = 9;

        // when
        step3.racingcar.model.RacingCarEngine carEngine = new RacingCarEngine(threshold);

        // then
        assertThat(carEngine.canRun()).isFalse();
    }

}
