package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    @DisplayName("test")
    void carTest() {
        int carCount = 3;
        int racingCount = 3;
        Circuit circuit = new Circuit(carCount, racingCount);
        circuit.startRacing();
    }
}
