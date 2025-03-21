package step4.racingcar2.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.racingcar2.exception.RacingCarEngineException;

public class RacingCarEngineTest {

    @Test
    @DisplayName("고장난 엔진(앞으로 못가는)")
    void givenAlwaysStopThreshold_whenRacingCarEngineCanRun_thenFalse() {
        // given
        int alwaysStopThreshold = 10;

        // when
        RacingCarEngine carEngineBroken = new RacingCarEngine(alwaysStopThreshold);

        // then
        assertThat(carEngineBroken.canRun()).isFalse();
    }

    @Test
    @DisplayName("베스트 엔진(앞으로 못가는)")
    void givenAlwaysGoThreshold_whenRacingCarEngineCanRun_thenTrue() {
        // given
        int alwaysGoThreshold = 0;

        // when
        RacingCarEngine carEngineBest = new RacingCarEngine(alwaysGoThreshold);

        // then
        assertThat(carEngineBest.canRun()).isTrue();
    }

    @Test
    @DisplayName("엔진 임계값 오류")
    void givenInvalidThreshold_whenCreateRacingCarEngine_thenThrowException() {
        // given
        int invalidThreshold = -1;

        // when
        assertThatThrownBy(() -> new RacingCarEngine(invalidThreshold))

            // then
            .isExactlyInstanceOf(RacingCarEngineException.class);
    }

}
