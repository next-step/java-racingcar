package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
  @Test
  @DisplayName("여러개의 Car로 Cars를 생성할 수 있으며, 생성된 Cars 내부의 Car가 생성자로 넘긴 Car와 동일한가")
  public void createCarsByManyCar() {
    //given
    List<Car> carList = new ArrayList<>();

    Car actualCar1 = Car.createCar();
    Car actualCar2 = Car.createCar();
    Car actualCar3 = Car.createCar();

    carList.add(actualCar1);
    carList.add(actualCar2);
    carList.add(actualCar3);

    //when
    Cars cars = new Cars(carList);

    //then
    List<Car> expectedCars = cars.getCars();
    assertAll(
        () -> assertEquals(expectedCars.get(0), actualCar1),
        () -> assertEquals(expectedCars.get(1), actualCar2),
        () -> assertEquals(expectedCars.get(2), actualCar3)
    );
  }

}