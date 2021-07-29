package step5;

import org.junit.jupiter.api.Test;
import step5.domain.CarEngine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarEngineTest {

    @Test
    void 자동차들은_4이상이여야만_갈수있다() {
        // given
        CarEngine carEngine = new CarEngine();
        int canMoveNumber = 4;
        int cantMoveNumber = 3;

        // when && then
        assertThat(carEngine.canMove(canMoveNumber)).isTrue();
        assertThat(carEngine.canMove(cantMoveNumber)).isFalse();
    }
}