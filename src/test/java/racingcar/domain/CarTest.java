package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.TestRandomNumberGenerator;

class CarTest {

  private final TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(System.currentTimeMillis());


  @ParameterizedTest
  @ValueSource(strings = {"aaa","bbb"})
  @DisplayName("static 메소드를 통해서 Car를 생성할 수 있는가")
  public void createCarUsingStaticMethod(String name) {
    //given
    Car expectedCar = Car.createCar(name);

    //when
    Car actualCar = new Car(name);

    //then
    assertEquals(expectedCar.getName(), actualCar.getName());

  }

  @Test
  @DisplayName("moveCar() 메소드를 통해서 현재 위치 상태를 변경할 수 있는가")
  public void changePositionUsingMethod() {
    //given
    Car car = Car.createCar("aaa");
    int initPosition = car.getPosition();

    //when
    car.moveCar(testRandomNumberGenerator.generateRandomNumber());
    int movedPosition = car.getPosition();

    //then
    assertEquals(initPosition+1, movedPosition);
  }
}