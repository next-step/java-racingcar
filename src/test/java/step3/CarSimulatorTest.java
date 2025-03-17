package step3;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarSimulatorTest {

    @Test
    void initAndMoveAllCars() {
        CarSimulator carSimulator = new CarSimulator();
        carSimulator.init(2, 3);

        carSimulator.simulate();

        List<String> positions = carSimulator.getPositions();
        assertThat(positions).isNotNull();
        assertThat(positions.size()).isEqualTo(2);
    }

}