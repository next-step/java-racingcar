package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarFactoryTest {

    @ParameterizedTest
    @DisplayName("입력한 수만큼 차가 만들어 졌는지")
    @CsvSource(value = {"car1,car2|2"}, delimiter = '|')
    void countMakeCars(String carName, int carCount) {
        RacingEventManager manager = new RacingEventManager(carName, 4);
        manager.startRandomRacing();
        assertThat(manager.getRacingResult().size()).isEqualTo(carCount);
    }
}
