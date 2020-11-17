package study.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step5.domain.Car;
import study.step5.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("우승자")
    public void winner() {
        Car pobi = new Car("pobi", 2);
        Car crong = new Car("crong", 2);
        Car honux = new Car("honux", 1);

        List<Car> original = Arrays.asList(pobi, crong, honux);
        Cars cars = new Cars(original);
        assertThat(cars.getWinners()).containsExactly(pobi, crong);
    }
}
