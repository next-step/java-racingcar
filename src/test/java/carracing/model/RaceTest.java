package carracing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    @Test
    @DisplayName("start(): 주어진 시도 횟수 크기의 List<RaceRecord>를 반환한다.")
    void testStart() {
        NumberOfCars numberOfCars = new NumberOfCars("3");
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts("5");

        Race race = new Race(numberOfCars, numberOfAttempts);
        List<RaceRecord> raceRecordList = race.start();

        assertThat(raceRecordList.size()).isEqualTo(numberOfAttempts.numberOfAttempts());
    }
}