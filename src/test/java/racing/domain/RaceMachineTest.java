package racing.domain;

import org.junit.jupiter.api.Test;
import racing.resolver.SupplierAccelerateResolver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceMachineTest {
    @Test
    void testRaceMachineAccelerate() {
        RaceMachine ferrari = new RaceMachine("Seba", new SupplierAccelerateResolver(() -> true));
        ferrari.accelerate();
        ferrari.accelerate();
        assertThat(ferrari.getLap()).isGreaterThan(2);
        assertThat(ferrari.getAccelerateResolver().resolve()).isTrue();

        RaceMachine mercedes = new RaceMachine("Lewis", new SupplierAccelerateResolver(() -> false));
        mercedes.accelerate();
        mercedes.accelerate();
        assertThat(mercedes.getLap()).isEqualTo(1);

    }

    @Test
    void testValidate() {
        assertThatThrownBy(() -> {
            new RaceMachine("", null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("반드시 필요");

        assertThatThrownBy(() -> {
            new RaceMachine("Lewis Hamilton", null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자를 초과");

    }
}

