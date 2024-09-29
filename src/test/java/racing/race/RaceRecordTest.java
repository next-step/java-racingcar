package racing.race;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.race.RaceGauge.FORWARD;
import static racing.race.RaceGauge.STOP;

public class RaceRecordTest {

    List<Boolean> forwardResults = List.of(true, false, false, true, false);

    @Test
    void forward_car() {
        RaceCar car = getRaceCar();
        RaceRecord record = car.raceRecord();

        for (int i = 0; i < forwardResults.size(); i++) {
            assertThat(record.raceResult(i))
                    .isEqualTo(forwardResults.get(i) ? FORWARD : STOP);
        }
    }

    private RaceCar getRaceCar() {
        RaceCar car = new RaceCar();
        forwardResults.forEach(car::race);
        return car;
    }
}
