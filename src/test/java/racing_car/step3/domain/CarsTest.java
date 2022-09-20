package racing_car.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    @DisplayName("차량 객체 생성 대수")
    void createCars() {
        List<Car> cars = Arrays.asList(new Car(), new Car(), new Car());
        assertThat(new Cars(cars)).isEqualTo(new Cars(CarsFactory.from(3)));
    }
}