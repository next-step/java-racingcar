package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CarTest {

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
  @DisplayName("moveCar() 메소드를 통해서 전진할 수 있는가")
  public void changePositionUsingMethod() {
    //given
    Car car = Car.createCar("aaa");
    Position initPosition = car.getPosition();

    //when
    car.moveCar(new RandomMovingStrategy(), 4);

    Position movedPosition = car.getPosition();
    initPosition.forwardPosition();

    //then
    assertEquals(initPosition, movedPosition);
  }

  @Test
  @DisplayName("moveCar() 메소드를 통해서 전진을 할 수 없을 경우가 있는가")
  public void notChangePositionUsingMethod() {
    //given
    Car car = Car.createCar("aaa");
    Position initPosition = car.getPosition();

    //when
    car.moveCar((new RandomMovingStrategy(), 4);

    Position movedPosition = car.getPosition();

    //then
    assertEquals(initPosition, movedPosition);
  }
}