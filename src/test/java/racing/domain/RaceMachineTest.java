package racing.domain;

import org.junit.jupiter.api.Test;
import racing.resolver.SupplierAccelerateResolver;

import static org.assertj.core.api.Assertions.assertThat;

class RaceMachineTest {
    @Test
    void testRaceMachineAccelerate() {
        RaceMachine ferrari = new RaceMachine("Sebastian Vettel", new SupplierAccelerateResolver(() -> true));
        ferrari.accelerate();
        ferrari.accelerate();
        assertThat(ferrari.getLap()).isGreaterThan(2);
        assertThat(ferrari.getAccelerateResolver().resolve()).isTrue();

        RaceMachine mercedes = new RaceMachine("Lewis Hamilton", new SupplierAccelerateResolver(() -> false));
        mercedes.accelerate();
        mercedes.accelerate();
        assertThat(mercedes.getLap()).isEqualTo(1);

    }
}

