package step5.racingcar3.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.racingcar3.exception.CarEngineException;

public class CarEngineTest {

    @Test
    @DisplayName("고장난 엔진(앞으로 못가는)")
    void givenAlwaysStopThreshold_whenCarEngineCanRun_thenFalse() {
        // given
        int alwaysStopThreshold = 10;

        // when
        CarEngine carEngineBroken = new CarEngine(alwaysStopThreshold);

        // then
        assertThat(carEngineBroken.canGo()).isFalse();
    }

    @Test
    @DisplayName("베스트 엔진(앞으로 못가는)")
    void givenAlwaysGoThreshold_whenCarEngineCanRun_thenTrue() {
        // given
        int alwaysGoThreshold = 0;

        // when
        CarEngine carEngineBest = new CarEngine(alwaysGoThreshold);

        // then
        assertThat(carEngineBest.canGo()).isTrue();
    }

    @Test
    @DisplayName("엔진 임계값 오류")
    void givenInvalidThreshold_whenCreateCarEngine_thenThrowException() {
        // given
        int invalidThreshold = -1;

        // when
        assertThatThrownBy(() -> new CarEngine(invalidThreshold))

            // then
            .isExactlyInstanceOf(CarEngineException.class);
    }

}
