package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

public class RaceHistoryTest {

    private RaceHistory raceHistory;
    private RaceHistory expectedHistory;
    private Cars cars;

    @BeforeEach
    void setUp() {
        raceHistory = new RaceHistory();
        expectedHistory = new RaceHistory();
        cars = Cars.createWithNames(Arrays.asList("pobi", "crong", "honux"));
        raceHistory.update(cars);
        expectedHistory.update(cars);
    }

    @Test
    void move() {
        cars = cars.move(() -> true);
        raceHistory.update(cars);

        List<Car> carList = Arrays.asList(Car.createWithNameAndPosition("pobi", 1),
                Car.createWithNameAndPosition("crong", 1),
                Car.createWithNameAndPosition("honux", 1));
        Cars expectedCars = Cars.createFromList(carList);
        expectedHistory.update(expectedCars);

        assertThat(raceHistory).isEqualTo(expectedHistory);
    }

    @Test
    void moves_multiple_times() {
        for (int i = 0; i < 2; i++) {
            cars = cars.move(() -> true);
            raceHistory.update(cars);
        }
        for (int i = 0; i < 2; i++) {
            List<Car> carList = Arrays.asList(Car.createWithNameAndPosition("pobi", i + 1),
                    Car.createWithNameAndPosition("crong", i + 1),
                    Car.createWithNameAndPosition("honux", i + 1));
            Cars expectedCars = Cars.createFromList(carList);
            expectedHistory.update(expectedCars);
        }
        assertThat(raceHistory).isEqualTo(expectedHistory);
    }
}
