package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @BeforeEach
    void setUp() {
        Cars.clear();
    }

    @Test
    @DisplayName("차 리스트에 차를 추가하는지 확인")
    void addCar() {
        Car car = new Car("truck");
        Cars.addCar(car);

        assertThat(Cars.getCars()).hasSize(1);
        assertThat(Cars.getCars()).contains(car);
    }

    @Test
    @DisplayName("차 리스트를 가져오는지 확인")
    void getCars() {
        Car car1 = new Car("truck");
        Car car2 = new Car("pobi");
        Cars.addCar(car1);
        Cars.addCar(car2);

        assertThat(Cars.getCars()).hasSize(2);
        assertThat(Cars.getCars()).containsExactly(car1, car2);
    }
}
