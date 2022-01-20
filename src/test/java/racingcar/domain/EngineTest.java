package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EngineTest {

    @Test
    void engineTest() {
        Engine justGoEngine = new FixedEngine(true);
        Engine justStopEngine = new FixedEngine(false);
        assertThat(justGoEngine.movable()).isTrue();
        assertThat(justStopEngine.movable()).isFalse();
    }
}
