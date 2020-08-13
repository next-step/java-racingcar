package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CircuitTest {

    private Circuit circuit;

    @BeforeEach
    void init() {
        circuit = new Circuit(Arrays.asList("pobi", "crong", "honux"), 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void getCars(String name) {
        Car car = new Car(name);
        assertThat(car).isIn(circuit.getCars());
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
