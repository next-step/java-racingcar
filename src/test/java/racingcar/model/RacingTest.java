package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    void 차_생성() {
        Racing racing = new Racing();

        Garage garage = racing.ready("a,b,c");

        assertThat(garage.getCars()).hasSize(3);
    }
}