package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.policy.fake.SuccessMovingPolicy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));
        carList.add(new Car("honux"));
        cars = new Cars(carList);
    }

    @DisplayName("자동차들이 총 1번 이동을 성공한다.")
    @Test
    void move() {
        // when
        cars.move(new SuccessMovingPolicy());

        // then
        for (Car car : cars.getCars()) {
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }
}