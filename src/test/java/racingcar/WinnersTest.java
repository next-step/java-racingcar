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
        Cars cars = new Cars("a", "b", "c");
        moveNthCarByDistance(cars, 1, 3);

        Records records = new Records(cars);

        Winners winners = new Winners(records);

        assertThat(winners.getNames().size()).isEqualTo(1);
        assertThat(winners.getNames()).contains("b");
        assertThat(winners.getDistance()).isEqualTo(new Distance(3));
    }

    private void moveNthCarByDistance(Cars cars, int n, int distance) {
        for (int d = 0; d < distance; d++) {
            int index = 0;
            for (Car car : cars) {
                if (index == n) {
                    car.move();
                }
                index++;
            }
        }
    }

    @Test
    @DisplayName("가장 잘한 기록이 여러개면 n size records 리턴")
    public void getBestRecords() {
        Cars cars = new Cars("a", "b", "c");

        moveNthCarByDistance(cars, 1, 2);
        moveNthCarByDistance(cars, 2, 2);

        Records records = new Records(cars);
        Winners winners = new Winners(records);

        assertThat(winners.getNames().size()).isEqualTo(2);
        assertThat(winners.getNames()).contains("c", "b");
        assertThat(winners.getDistance()).isEqualTo(new Distance(2));
    }
}