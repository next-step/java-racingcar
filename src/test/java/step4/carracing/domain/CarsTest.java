package step4.carracing.domain;

import org.junit.jupiter.api.Test;
import step4.carracing.CarMoveStrategyTest;
import step4.carracing.RandomCarMoveStrategy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

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

  @Test
  void testMoveCars() {
    Cars cars = new Cars(
      List.of(
        new Car("pobi", new CarMoveStrategyTest.TestAlwaysCarMoveStrategy()),
        new Car("crong", new CarMoveStrategyTest.TestStoppedCarMoveStrategy())
      )
    );

    cars.moveCars();

    assertTrue(cars.get("pobi").isSame(1));
    assertTrue(cars.get("crong").isSame(0));
  }

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