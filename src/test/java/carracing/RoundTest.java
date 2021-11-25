package carracing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @Test
    void roundWithForwardedCar() {
        Car car = new Car("car");
        car.stepForward(() -> true);

        List<Car> cars = new ArrayList<>();
        cars.add(car);

        Round round = new Round(cars);
        assertThat(round.getStep("car")).isEqualTo(1);
    }

    @Test
    void roundWithNonForwardedCar() {
        Car car = new Car("car");
        car.stepForward(() -> false);

        List<Car> cars = new ArrayList<>();
        cars.add(car);

        Round round = new Round(cars);
        assertThat(round.getStep("car")).isEqualTo(0);
    }

    @Test
    void getSteps() {
        Car car = new Car("car");
        car.stepForward(() -> true);

        List<Car> cars = new ArrayList<>();
        cars.add(car);

        Round round = new Round(cars);
        Map<CarName, Integer> steps = round.getSteps();

        int step = steps.get(new CarName("car"));
        assertThat(step).isEqualTo(1);
    }
}