package carracing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void winnersTest() {
        Car carA = new Car("car A", 5);
        Car carB = new Car("car B", 1);
        Car carC = new Car("car C", 4);
        Car carD = new Car("car D", 3);

        List<Car> carList = Arrays.asList(carA, carB, carC, carD);
        Cars cars = new Cars(carList);

        assertThat(cars.getWinners()).containsExactly("car A", "car C");
    }
}
