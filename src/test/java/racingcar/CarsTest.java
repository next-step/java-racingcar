package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void drive() throws Exception {
        Cars cars = new Cars(() -> true, 3);
        cars.drive();
        List<Integer> drivingDistances = cars.drivingDistances();

        assertThat(drivingDistances).containsExactly(1, 1, 1);
    }

    @Test
    void notDrive() throws Exception {
        Cars cars = new Cars(() -> false, 3);
        cars.drive();
        List<Integer> drivingDistances = cars.drivingDistances();

        assertThat(drivingDistances).containsExactly(0, 0, 0);
    }

    @Test
    void getResult() throws Exception {
        Cars cars = new Cars(() -> true, 3);

        cars.drive();
        assertThat(cars.getResult()).isEqualTo("-\n-\n-");

        cars.drive();
        assertThat(cars.getResult()).isEqualTo("--\n--\n--");
    }
}
