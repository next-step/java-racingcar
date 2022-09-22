package racing_car.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsFactoryTest {
    
    @Test
    @DisplayName("차량 객체 생성")
    void createCars() {
        List<Car> cars = CarsFactory.from(new String[]{"pobi", "jun", "young"});
        assertThat(cars).hasSize(3);
    }
}