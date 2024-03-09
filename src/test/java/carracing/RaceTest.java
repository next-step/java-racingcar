package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    @Test
    @DisplayName("주어진 시도 횟수 크기의 List<RaceStatus>를 반환한다.")
    void testStart() {
        int numberOfCars = 3;
        int numberOfAttempts = 5;

        Race race = new Race(numberOfCars, numberOfAttempts);
        List<RaceStatus> raceStatusList = race.start();

        assertThat(raceStatusList.size()).isEqualTo(numberOfAttempts);
    }
}