package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HistoryTest {

    @Test
    void 히스토리_저장_및_확인() {
        History history = new History();
        Cars cars = Cars.newInstance("a,b,c", () -> true);
        for (int i = 0; i < 5; i++) {
            cars.race();
            history.add(cars);
        }

        for (int i = 0; i < 5; i++) {
            Cars carsWithHistory = history.get(i);
            List<Car> carsForHistory = carsWithHistory.get();
            for (Car car : carsForHistory) {
                assertThat(car.getDistance()).isEqualTo(i + 1);
            }
        }
    }
}
