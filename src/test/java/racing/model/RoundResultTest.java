package racing.model;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultTest {

    @Test
    void roundRecords() {
        List<Car> cars = new LinkedList<>();
        Car car1 = new Car("car1");
        car1.move(5);
        car1.move(5);
        cars.add(car1);
        Car car2 = new Car("car2");
        car2.move(5);
        cars.add(car2);
        Car car3 = new Car("car3");
        cars.add(car3);

        RoundResult roundResult = new RoundResult(cars);
        assertThat(roundResult.records()).contains(car1, car2, car3);

    }

}