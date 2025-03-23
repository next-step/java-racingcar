package step4.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.carracing.CarMoveStrategyTest;
import step4.carracing.RandomCarMoveStrategy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

  @DisplayName("자동차 목록 중에서 최대 위치를 구하는 기능 테스트")
  @Test
  void testGetMaxPosition() {
    Cars cars = new Cars(
      List.of(
        new Car(1, "pobi", new RandomCarMoveStrategy()),
        new Car(2, "crong", new RandomCarMoveStrategy()),
        new Car(3, "honux", new RandomCarMoveStrategy())
      )
    );

    int maxPosition = cars.getMaxPosition();

    assertEquals(3, maxPosition);
  }

  @DisplayName("자동차 목록 중에서 특정 위치에 있는 자동차들을 필터링하는 기능 테스트")
  @Test
  void testFilterCarsWithCertainPosition() {
    Cars cars = new Cars(
      List.of(
        new Car(1, "pobi", new RandomCarMoveStrategy()),
        new Car(2, "crong", new RandomCarMoveStrategy()),
        new Car(3, "honux", new RandomCarMoveStrategy())
      )
    );

    Cars filteredCars = cars.filterCarsWithCertainPosition(2);

    assertEquals(1, filteredCars.size());
  }

  @DisplayName("자동차 목록을 이동시키는 기능 테스트")
  @Test
  void testMoveCars() {
    Cars cars = new Cars(
      List.of(
        new Car("pobi", new CarMoveStrategyTest.TestAlwaysCarMoveStrategy()),
        new Car("crong", new CarMoveStrategyTest.TestStoppedCarMoveStrategy())
      )
    );

    cars.moveCars();

    assertTrue(cars.get("pobi").isSamePosition(1));
    assertTrue(cars.get("crong").isSamePosition(0));
  }

  @DisplayName("자동차 목록의 크기를 구하는 기능 테스트")
  @Test
  void testSize() {
    Cars cars = new Cars(
      List.of(
        new Car("pobi", new RandomCarMoveStrategy()),
        new Car("crong", new RandomCarMoveStrategy())
      )
    );

    assertEquals(2, cars.size());
  }

  @DisplayName("자동차 목록 중에서 이름으로 자동차를 찾는 기능 테스트")
  @Test
  void testGet() {
    Cars cars = new Cars(
      List.of(
        new Car("pobi", new RandomCarMoveStrategy()),
        new Car("crong", new RandomCarMoveStrategy())
      )
    );

    Car car = cars.get("pobi");

    assertEquals("pobi", car.getName());
  }
}