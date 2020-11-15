package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("우승자")
    public void winner() {
        Car pobi = new Car("pobi", 2, 2);
        Car crong = new Car("crong", 2, 2);
        Car honux = new Car("honux", 1, 1);

        List<Car> original = Arrays.asList(pobi, crong, honux);
        Cars cars = new Cars(original);
        cars.winner();
        assertThat(cars.getWinners()).containsExactly(pobi, crong);
    }
}
