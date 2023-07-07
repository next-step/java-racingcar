package car;

import static org.assertj.core.api.Assertions.assertThat;

import car.domain.RacingService;
import org.junit.jupiter.api.Test;

public class RacingServiceTest {

    @Test
    void 자동차_경주_실행() {
        String carName = "jjung";
        int count = 1;
        boolean isExpectedRacing = true;

        RacingService racingService = new RacingService(carName, count);

        assertThat(racingService).extracting(RacingService::isRacing).isEqualTo(isExpectedRacing);
    }

    @Test
    void 자동차_경주_완료() {
        String carName = "jjung";
        int count = 0;
        boolean isExpectedRacing = false;

        RacingService racingService = new RacingService(carName, count);

        assertThat(racingService).extracting(RacingService::isRacing).isEqualTo(isExpectedRacing);
    }

    @Test
    void 자동차_경주_1회_실행() {
        String carName = "jjung";
        int totalRaceCount = 1;
        int expectedRaceCount = 0;

        RacingService racingService = new RacingService(carName, totalRaceCount);
        racingService.runRaceOnce();

        assertThat(racingService).extracting("count")
            .extracting("tryCount").isEqualTo(expectedRaceCount);
    }
}
