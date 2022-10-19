package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racing_game.controller.Simulator;
import racing_game.core.Positive;

class SimulatorTest {

    @Test
    void simulate() {
        List<CarName> carNames = List.of(
            new CarName("test1"), new CarName("test2"), new CarName("test3")
        );
        Positive tryCount = Positive.of(4);
        SnapShot result = new Simulator().simulate(tryCount, carNames);
        assertThat(result).isNotNull();
        assertThat(result.get().size()).isEqualTo(4);
        assertThat(result.get().get(0).size()).isEqualTo(3);
    }
}
