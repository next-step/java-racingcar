package racing.domain;

import com.racing.domain.Car;
import com.racing.domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("Cars 객체가 정상적으로 만들어지는지 여부")
    public void createCarsTest() {
        Car pobyCar = new Car(5, "poby");
        Car jongCar = new Car(3, "jong");
        Car leeCar = new Car(3, "lee");

        List<Car> oiginalCarList = Arrays.asList(pobyCar, jongCar, leeCar);
        Cars cars = new Cars(oiginalCarList);

        assertThat(new Cars(Arrays.asList(pobyCar, jongCar, leeCar))).isEqualTo(cars);
    }
}
