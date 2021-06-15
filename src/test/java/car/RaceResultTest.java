package car;

import car.domain.Car;
import car.domain.RaceResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class RaceResultTest {
    @Test
    void getCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("java", 1));
        cars.add(new Car("php", 2));
        cars.add(new Car("python", 3));

        RaceResult raceResult = new RaceResult(cars);

        assertThat(raceResult.getCars()).extracting("name", "km").contains(
                tuple("java", 1),
                tuple("php", 2),
                tuple("python", 3)
        );
    }
}
