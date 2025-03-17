package step3;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarSimulatorTest {
    @Test
    @DisplayName("시뮬레이션 후 히스토리 크기를 확인한다")
    void historySize() {
        CarSimulator carSimulator = new CarSimulator(2, 3);
        carSimulator.simulate();

        List<CarPositions> history = carSimulator.getHistory();
        assertThat(history).isNotNull();
        assertThat(history.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("초기 상태에서 히스토리가 비어 있는지 확인한다")
    void initialHistory() {
        CarSimulator carSimulator = new CarSimulator(2, 3);
        List<CarPositions> history = carSimulator.getHistory();
        assertTrue(history.isEmpty());
    }
}