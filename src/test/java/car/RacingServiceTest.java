package car;

import static org.assertj.core.api.Assertions.assertThat;

import car.domain.RacingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingServiceTest {

    @DisplayName("자동차 경주 횟수가 남았을 시 경주 진행 여부 true/false 리턴")
    @Test
    void isCarRaceRemin() {
        String carName = "jjung";
        int count = 1;
        boolean isExpectedRacing = true;

        RacingService racingService = new RacingService(carName, count);
        assertThat(racingService).extracting(RacingService::isRacing).isEqualTo(isExpectedRacing);
    }

    @DisplayName("자동차 경주 횟수가 0 일때 경주 진행 여부 true/false 리턴")
    @Test
    void isCarRaceOver() {
        String carName = "jjung";
        int count = 0;
        boolean isExpectedRacing = false;

        RacingService racingService = new RacingService(carName, count);

        assertThat(racingService).extracting(RacingService::isRacing).isEqualTo(isExpectedRacing);
    }

    @DisplayName("자동차 경주 진행 시, 횟수가 1 감소 하는지 테스트")
    @Test
    void runRaceOnce() {
        String carName = "jjung";
        int totalRaceCount = 1;
        int expectedRaceCount = 0;

        RacingService racingService = new RacingService(carName, totalRaceCount);
        racingService.runRaceOnce();

        assertThat(racingService).extracting("count")
            .extracting("tryCount").isEqualTo(expectedRaceCount);
    }
}
