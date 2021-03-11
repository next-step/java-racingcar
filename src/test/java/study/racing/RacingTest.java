package study.racing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

  private Cars cars;

  @BeforeEach
  void dummy() {
    Car car1 = new Car(1);
    Car car2 = new Car(0);
    Car car3 = new Car(3);
    Cars cars = new Cars();
    cars.addAll(car1, car2, car3);
  }

  @Test
  @DisplayName("count 만큼 차를 생성한다.")
  void createCars() {
    Cars cars = Racing.createCars(3);
    assertEquals(cars.getSize(), 3);
  }

}