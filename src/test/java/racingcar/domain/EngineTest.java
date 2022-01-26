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

    @Test
    void 랜덤_엔진_테스트() {
        RandomEngine randomEngine = new RandomEngine();
        int randInt = randomEngine.createRandom();
        assertThat(randInt < 10).isTrue();
        assertThat(randInt > 0).isTrue();
        }

    }
