package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    void 차_생성() {
        Racing racing = new Racing();

        CarManager carManager = racing.ready("a,b,c");

        assertThat(carManager.getCars()).hasSize(3);
    }
}