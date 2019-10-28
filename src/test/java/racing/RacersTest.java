package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacersTest {
    @Test
    @DisplayName("정해진 우승자가 나오는지 테스트")
    void winner() {
        List<Car> cars = getCars();
        Car expectedCar = getExpectedCar();
        cars.add(expectedCar);
        Racers racers = new Racers(cars);

        assertThat(racers.winner()).containsExactly(expectedCar.getName());
    }

    private Car getExpectedCar() {
        Car expectedCar = new Car("dave");
        expectedCar.move(9);
        expectedCar.move(9);
        expectedCar.move(9);

        return expectedCar;
    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));

        return cars;
    }
}
