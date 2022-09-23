package racing_car.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsFactoryTest {
    
    @Test
    @DisplayName("차량 객체 생성")
    void createCars() {
        List<Car> actualCars = CarsFactory.from(new String[]{"pobi", "jun", "young"});
        List<Car> expectedCars = Arrays.asList(new Car(new CarName("pobi"), new Position(0)), new Car(new CarName("jun"), new Position(0)), new Car(new CarName("young"), new Position(0)));
        assertThat(actualCars).isEqualTo(expectedCars);
    }
}