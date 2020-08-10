package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircuitTest {

    private Circuit circuit;

    @BeforeEach
    void init() {
        circuit = new Circuit(3, 5);
    }

    @Test
    void lap() {
        int rounds = circuit.getRounds();
        for (int i = 0; i < rounds; i++) {
            circuit.lap();
        }
        assertThat(circuit.getRounds()).isEqualTo(0);
    }
}
