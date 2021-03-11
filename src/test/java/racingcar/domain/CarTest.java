package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.TestRandomNumberGenerator;

class CarTest {

  private final TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(System.currentTimeMillis());

  @Test
  @DisplayName("static 메소드를 통해서 Car를 생성할 수 있는가")
  public void createCarUsingStaticMethod() {
    //given
    Car expectedCar = Car.createCar();

    //when
    Car actualCar = new Car();

    //then
    assertEquals(expectedCar.getClass(), actualCar.getClass());
  }

  @Test
  @DisplayName("moveCar() 메소드를 통해서 현재 위치 상태를 변경할 수 있는가")
  public void changePositionUsingMethod() {
    //given
    Car car = Car.createCar();
    int initPosition = car.getPosition();

    //when
    car.moveCar(testRandomNumberGenerator.generateRandomNumber());
    int movedPosition = car.getPosition();

    //then
    assertEquals(initPosition+1, movedPosition);
  }
}