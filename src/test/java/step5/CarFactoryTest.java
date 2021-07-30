package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
    @Test
    @DisplayName("Car 오브젝트가 지정된 이름대로 생성되는지 테스트")
    void createCarsFromNames() {
        List<Car> cars = CarFactory.createCarsFromNames(Stream.of("a", "b", "c").collect(Collectors.toList()));

        assertThat(cars.stream()
                .map(Car::getCarName)
                .map(CarName::getValue)
                .collect(Collectors.toList())).contains("a", "b", "c");

        cars.forEach(car -> assertThat(car).isInstanceOf(Car.class));
    }
}
