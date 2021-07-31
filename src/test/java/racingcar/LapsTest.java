package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LapsTest {
    private Laps laps = new Laps();

    @Test
    @DisplayName("record 하면 주어진 cars 의 distance 를 Lap으로 기록한다")
    public void record() {
        Cars cars = new Cars(Arrays.asList(new Car("a", 1), new Car("b", 2)));

        laps.record(cars);

        for (Lap lap : laps) {
            for (Record record : lap.getRecords()) {
                assertThat(record.getDistance()).isIn(1, 2);
            }
        }
    }
}