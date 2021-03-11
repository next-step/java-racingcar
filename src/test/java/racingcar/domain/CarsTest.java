package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.TestRandomNumberGenerator;

class CarsTest {

  private Cars cars;
  private final TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(System.currentTimeMillis());

  @BeforeEach
  public void createCars() {
    List<Car> carList = new ArrayList<>();

    Car car1 = Car.createCar();
    Car car2 = Car.createCar();
    Car car3 = Car.createCar();

    carList.add(car1);
    carList.add(car2);
    carList.add(car3);

    cars = new Cars(carList);
  }

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

  @Test
  @DisplayName("현재 자동차들의 전체 위치를 출력할 수 있는가")
  public void printAllCarsPosition() {

    //when
    String expectString = cars.currentCarsPosition();

    //then
    String actualString =  "-" + "\n" + "-" + "\n" + "-" + "\n";

    assertEquals(expectString, actualString);
  }

  @Test
  @DisplayName("현재 자동차들의 전체 위치를 변경할 수 있는가")
  public void updateAllCarsPosition() {

    //when
    cars.updateAll(testRandomNumberGenerator);

    //then
    List<Car> expectedCars = cars.getCars();
    assertAll(
        () -> assertEquals(expectedCars.get(0).getPosition(), 1),
        () -> assertEquals(expectedCars.get(1).getPosition(), 1),
        () -> assertEquals(expectedCars.get(2).getPosition(), 1)
    );
  }
}