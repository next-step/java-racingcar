package stydy.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racing.domain.Car;
import study.racing.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Car 객체 생성 테스트")
    public void carCreate() {
        Car car = new Car.Builder()
                .setCarNo(1)
                .setCarName("TestCar")
                .setMoveCount(5)
                .build();

        assertThat(car.getCarNo()).isEqualTo(1);
        assertThat(car.getCarName()).isEqualTo("TestCar");
        assertThat(car.getMoveCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("Cars 클래스 초기화 테스트")
    public void carsInitialization() {
        Car car1 = new Car.Builder().setCarName("Car1").setMoveCount(0).build();
        Car car2 = new Car.Builder().setCarName("Car2").setMoveCount(0).build();
        List<Car> carList = Arrays.asList(car1, car2);

        Cars cars = new Cars(carList);

        assertThat(cars.getCarList()).hasSize(2);
        assertThat(cars.getCarList()).extracting(Car::getCarName)
                .contains("Car1", "Car2");
    }

    @Test
    @DisplayName("initOfCar 메소드 테스트")
    public void initOfCar() {
        Cars cars = Cars.initOfCar(3);

        assertThat(cars.getCarList()).hasSize(3);
        assertThat(cars.getCarList()).extracting(Car::getCarNo)
                .containsExactly(0, 1, 2);
    }
}


