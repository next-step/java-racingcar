package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarFactoryTest {

  @DisplayName("자동차 생성 테스트")
  @Test
  void testCreateCar() {
    Car car = CarFactory.createCar("pobi");
    Assertions.assertEquals("pobi", car.getName());
    Assertions.assertEquals(1, car.getPosition());
  }

  @DisplayName("자동차 리스트 생성 테스트")
  @Test
  void testCreateCars() {
    List<Car> carList = CarFactory.createCars(List.of("pobi", "crong", "honux"));

    Assertions.assertEquals(3, carList.size());
    Assertions.assertEquals("pobi", carList.get(0).getName());
    Assertions.assertEquals(1, carList.get(0).getPosition());
  }
}