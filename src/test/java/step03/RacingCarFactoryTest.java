package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarFactoryTest {

    @ParameterizedTest
    @DisplayName("입력한 수만큼 차가 만들어 졌는지")
    @ValueSource(ints = {1, 2, 3})
    void countMakeCars(int carCount) {
        RacingEventManager manager = new RacingEventManager(carCount, 4);
        manager.startRacing();
        assertThat(manager.getRacingResult().size()).isEqualTo(carCount);
    }
}
