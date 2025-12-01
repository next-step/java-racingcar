package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    @Test
    public void 최대_위치_테스트() {
        List<Car> carList = Arrays.asList(
                new Car("LEE", 5),
                new Car("SON", 3),
                new Car("KIM", 4)
        );


        Cars cars = new Cars(carList);
        assertThat(cars.getMaxPosition()).isEqualTo(new Position(5));
    }

    @Test
    public void 우승자() {
        List<Car> carList = Arrays.asList(
                new Car("LEE", 6),
                new Car("SON", 6),
                new Car("KIM", 4)
        );

        Cars cars = new Cars(carList);
        assertThat(cars.getWinners()).containsExactlyInAnyOrder("LEE", "SON");
    }
}
