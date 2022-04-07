package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("아규먼트로 들어온 숫자만큼 자동차들은 이동한다.")
    void carsMovementTest() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.move(1);
        car1.move(2);
        car1.move(3);

        List<Integer> movementList = List.of(1, 2, 3);
        Cars testCars = new Cars(List.of(new Car(), new Car(), new Car()));

        //when
        List<Integer> currentLocations = testCars.move(movementList);

        //then
        assertThat(currentLocations.get(0)).isEqualTo(car1.getCurrentLocation());
        assertThat(currentLocations.get(1)).isEqualTo(car2.getCurrentLocation());
        assertThat(currentLocations.get(2)).isEqualTo(car3.getCurrentLocation());
    }

}