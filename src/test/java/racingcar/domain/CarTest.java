package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
=======
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
import racingcar.util.TestRandomNumberGenerator;

class CarTest {

  private final TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(System.currentTimeMillis());

<<<<<<< HEAD
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
=======
  @Test
  @DisplayName("static 메소드를 통해서 Car를 생성할 수 있는가")
  public void createCarUsingStaticMethod() {
    //given
    Car expectedCar = Car.createCar();

    //when
    Car actualCar = new Car();

    //then
    assertEquals(expectedCar.getClass(), actualCar.getClass());
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  }

  @Test
  @DisplayName("moveCar() 메소드를 통해서 현재 위치 상태를 변경할 수 있는가")
  public void changePositionUsingMethod() {
    //given
<<<<<<< HEAD
    Car car = Car.createCar("aaa");
=======
    Car car = Car.createCar();
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
    int initPosition = car.getPosition();

    //when
    car.moveCar(testRandomNumberGenerator.generateRandomNumber());
    int movedPosition = car.getPosition();

    //then
    assertEquals(initPosition+1, movedPosition);
  }
}