package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LapTest {
    @Test
    @DisplayName("가장 잘한 기록이 하나면 하나짜리 records 리턴")
    public void getBestRecord() {
        Lap lap = new Lap(new Cars(new Car("a", 0), new Car("b", 2), new Car("c", 3)));

        Records records = lap.getBestRecords();

        for (Record record : records) {
            assertThat(record.getName()).isEqualTo("c");
            assertThat(record.getDistance()).isEqualTo(3);
        }
    }

    @Test
    @DisplayName("가장 잘한 기록이 여러개면 n size records 리턴")
    public void getBestRecords() {
        Lap lap = new Lap(new Cars(new Car("a", 0), new Car("b", 3), new Car("c", 3)));

        Records records = lap.getBestRecords();

        for (Record record : records) {
            assertThat(record.getName()).isIn("b", "c");
            assertThat(record.getDistance()).isEqualTo(3);
        }
    }
}