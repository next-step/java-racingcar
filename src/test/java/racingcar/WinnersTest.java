package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Distance;
import racingcar.domain.Record;
import racingcar.domain.Records;
import racingcar.domain.Winners;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    @DisplayName("가장 잘한 기록이 하나면 한명의 이름을 가진 Winner")
    public void getBestRecord() {
        Records records = new Records(new Cars(new Car("a", 0), new Car("b", 3), new Car("c", 2)));
        Winners winners = new Winners();
        for (Record record : records) {
            winners.updateWinner(record);
        }

        assertThat(winners.getNames().size()).isEqualTo(1);
        assertThat(winners.getNames()).contains("b");
        assertThat(winners.getDistance()).isEqualTo(new Distance(3));
    }

    @Test
    @DisplayName("가장 잘한 기록이 여러개면 n size records 리턴")
    public void getBestRecords() {
        Records records = new Records(new Cars(new Car("a", 0), new Car("b", 2), new Car("c", 2)));
        Winners winners = new Winners();
        for (Record record : records) {
            winners.updateWinner(record);
        }

        assertThat(winners.getNames().size()).isEqualTo(2);
        assertThat(winners.getNames()).contains("c", "b");
        assertThat(winners.getDistance()).isEqualTo(new Distance(2));
    }
}