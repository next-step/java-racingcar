import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName(value = "자동차 일급 컬렉션 테스트")
class CarsTest {
    Cars cars = Setup.cars;
    Car car = Setup.car;

    @Test
    void addCar() {
        cars.addCar(car);
        assertTrue(cars.hasCar(car));
    }

    @Test
    void getWinningCar(){
        Car car1 = new Car("바나나차차");
        Car car2 = new Car("딸기차차");
        Car car3 = new Car("토마토차차");

        car1.run();
        car2.run();
        car3.stop();

        car1.run();
        car2.run();
        car3.stop();

        cars.addCar(car3);
        cars.addCar(car2);
        cars.addCar(car1);

        List<Car> winningCar = cars.getWinningCar(2);
        assertTrue(winningCar.contains(car2));
        assertTrue(winningCar.contains(car1));
    }



}