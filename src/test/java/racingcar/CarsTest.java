package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("아규먼트로 들어온 숫자만큼 자동차들은 이동한다.")
    void carsMovementTest() {
        //given
        Car car1 = new Car("자동차1");
        Car car2 = new Car("자동차2");
        Car car3 = new Car("자동차3");

        car1.move(1);
        car1.move(2);
        car1.move(3);

        List<Integer> movementList = List.of(1, 2, 3);
        Cars testCars = new Cars(List.of(new Car("자동차1"), new Car("자동차2"), new Car("자동차3")));

        //when
        List<CarLocationResult> carLocationResults = testCars.move(movementList);

        //then
        assertThat(carLocationResults).containsExactly(
                new CarLocationResult(car1),
                new CarLocationResult(car2),
                new CarLocationResult(car3)
        );
    }

}