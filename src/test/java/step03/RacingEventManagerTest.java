package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingEventManagerTest {
    @ParameterizedTest
    @CsvSource(value = {"car1,car2|2"}, delimiter = '|')
    @DisplayName("입력한 수만큼 차가 만들어 졌는지")
    void countMakeCars(String carNames, int carCount) {
        RacingEventManager manager = new RacingEventManager(carNames, 4);
        manager.startRandomRacing();
        assertThat(manager.getRacingResult().size()).isEqualTo(carCount);
    }
}
