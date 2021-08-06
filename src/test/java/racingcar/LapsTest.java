package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Lap;
import racingcar.domain.Laps;
import racingcar.domain.Names;
import racingcar.domain.Record;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LapsTest {
    private Laps laps = new Laps();

    @Test
    @DisplayName("record 하면 주어진 cars 의 distance 를 Lap으로 기록한다")
    public void record() {
        Cars cars = new Cars(new Names(Arrays.asList("a", "b")));

        laps.record(cars);

        for (Lap lap : laps) {
            for (Record record : lap.getRecords()) {
                assertThat(record.getDistance()).isEqualTo(0);
            }
        }
    }
}