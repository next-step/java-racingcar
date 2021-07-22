package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarEngineTest {

    @Test
    void 자동차들은_4이상이여야만_갈수있다() {
        // given
        CarEngine carEngine = new CarEngine();
        int canGoNumber = 4;
        int cantGoNumber = 3;

        // when && then
        assertThat(carEngine.canGo(canGoNumber)).isTrue();
        assertThat(carEngine.canGo(cantGoNumber)).isFalse();
    }
}