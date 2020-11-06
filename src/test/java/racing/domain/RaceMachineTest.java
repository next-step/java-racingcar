package racing.domain;

import org.junit.jupiter.api.Test;
import racing.resolver.SupplierAccelerateResolver;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceMachineTest {
    @Test
    void testRaceMachineAccelerate() {
        RaceMachine ferrari = new RaceMachine(1, new SupplierAccelerateResolver(() -> {
            return true;
        }));
        ferrari.accelerate();
        ferrari.accelerate();
        assertThat(ferrari.getLap()).isGreaterThan(2);
        assertThat(ferrari.getAccelerateResolver().resolve()).isTrue();

        RaceMachine avante = new RaceMachine(2, new SupplierAccelerateResolver(() -> {
            return false;
        }));
        avante.accelerate();
        avante.accelerate();
        assertThat(avante.getLap()).isEqualTo(1);

    }
}

