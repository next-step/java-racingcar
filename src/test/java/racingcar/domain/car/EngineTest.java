package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EngineTest {

    @Test
    void 단일_동작_엔진_테스트() {
        Engine justGoEngine = new FixedEngine(true);
        Engine justStopEngine = new FixedEngine(false);
        assertThat(justGoEngine.movable()).isTrue();
        assertThat(justStopEngine.movable()).isFalse();
    }
}
