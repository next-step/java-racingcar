package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.carracing.domain.Car;
import step4.carracing.domain.Cars;

import java.util.List;

public class CarFactoryTest {

  @DisplayName("자동차 리스트 생성 테스트")
  @Test
  void testCreateCars() {
    List<String> inputNames = List.of("pobi", "crong", "honux");
    Cars cars = CarFactory.createCars(inputNames, new RandomCarMoveStrategy());

    Assertions.assertEquals(inputNames.size(), cars.size());

    for (Car car: cars) {
      Assertions.assertTrue(inputNames.contains(car.getName()));
      Assertions.assertTrue(car.isSamePosition(0));
    }
  }
}