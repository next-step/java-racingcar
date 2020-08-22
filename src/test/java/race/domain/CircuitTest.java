package race.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.domain.Car;
import race.domain.Circuit;

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

    @Test
    void getWinnerIllegalStateException() {
        int rounds = circuit.getRounds();
        if (rounds > 0) {
            assertThatThrownBy(() -> circuit.getWinners()).isInstanceOf(IllegalStateException.class);
        }
    }
}
