package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차 중 가장 멀리간 자동차를 구한다")
    public void max_position_cars() {
        Car pobi = new Car("pobi", 1);
        Car crong = new Car("crong", 3);
        Car honux = new Car("honux", 2);
        Cars cars = new Cars(Arrays.asList(pobi, crong, honux));

        Cars maxCars = cars.maxPositionCars();
        assertThat(maxCars).extracting(Cars::cars).isEqualTo(Arrays.asList(crong));
    }

}
