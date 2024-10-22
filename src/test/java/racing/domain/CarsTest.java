package racing.domain;

import com.racing.domain.Car;
import com.racing.domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @Test
    @DisplayName("addCars 메서드가 Car 객체를 정상적으로 추가하는지 여부")
    public void addCarsTest() {
        Cars cars = new Cars();
        Car newCar = new Car(4, "newCar");

        cars.addCars(newCar);

        assertThat(cars.getItems()).hasSize(1);
        assertThat(cars.getItems().get(0)).isEqualTo(newCar);
    }

    @Test
    @DisplayName("carsSize 메서드가 정확한 자동차 수를 반환하는지 테스트")
    void carsSizeTest() {
        Car car1 = new Car(3, "car1");
        Car car2 = new Car(3, "car2");
        Car car3 = new Car(3, "car3");
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        int size = cars.carsSize();

        assertThat(size).isEqualTo(3);
    }

    @Test
    @DisplayName("getCarName 메서드 테스트")
    void getCarNameTest() {
        Car car1 = new Car(3, "pobi");
        Car car2 = new Car(3, "crong");
        Cars cars = new Cars(Arrays.asList(car1, car2));

        assertThat(cars.getCarName(0)).isEqualTo("pobi");
        assertThat(cars.getCarName(1)).isEqualTo("crong");
        assertThatThrownBy(() -> cars.getCarName(2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
