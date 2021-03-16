package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

class CarsTest {

  private Cars cars;

  @BeforeEach
  public void createCars() {
    List<Car> carList = new ArrayList<>();

    Car car1 = Car.createCar("aaa");
    Car car2 = Car.createCar("bbb");
    Car car3 = Car.createCar("ccc");

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

    Car actualCar1 = Car.createCar("aaa");
    Car actualCar2 = Car.createCar("bbb");
    Car actualCar3 = Car.createCar("ccc");

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
    String actualString = "aaa : " + "-" + "\n" + "bbb : " + "-" + "\n" + "ccc : " +  "-" + "\n";

    assertEquals(expectString, actualString);
  }

  @Test
  @DisplayName("현재 자동차들의 전체 위치를 변경할 수 있는가")
  public void updateAllCarsPosition() {

    //when
    cars.updateAll(new RandomNumberGenerator(System.currentTimeMillis()) {
      @Override
      public int generateRandomNumber() {
        return 4;
      }
    });

    //then
    List<Car> expectedCars = cars.getCars();
    assertAll(

        () -> assertEquals(expectedCars.get(0).getPosition(), new Position(1)),
        () -> assertEquals(expectedCars.get(1).getPosition(), new Position(1)),
        () -> assertEquals(expectedCars.get(2).getPosition(), new Position(1))
    );
  }

  @Test
  @DisplayName("제일 높은 position을 통해서 우승자의 이름을 뽑아낼 수 있는가")
  public void getWinnerNameByPosition() throws Exception {
    //given
    cars.updateAll(new RandomNumberGenerator(System.currentTimeMillis()) {
      @Override
      public int generateRandomNumber() {
        return 4;
      }
    });

    //when
    List<CarName> expectedWinners = cars.getWinner();
    List<CarName> actualWinners = new ArrayList<>();
    actualWinners.add(new CarName("aaa"));
    actualWinners.add(new CarName("bbb"));
    actualWinners.add(new CarName("ccc"));

    //then
    List<Car> expectedCars = cars.getCars();
    assertAll(
        () -> assertEquals(expectedWinners, actualWinners),
        () -> assertEquals(expectedCars.get(0).getPosition(), cars.getCars().get(0).getPosition()),
        () -> assertEquals(expectedCars.get(1).getPosition(), cars.getCars().get(1).getPosition()),
        () -> assertEquals(expectedCars.get(2).getPosition(), cars.getCars().get(2).getPosition())
    );
  }

}