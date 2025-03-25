package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  void getName() {
    Car car = new Car("test");
    assertEquals("test", car.getName());
  }

  @Test
  void move() {
    Car car = new Car("test");
    car.move();
    car.move();
    assertEquals(2, car.getScore());
  }

  @Test
  void mergeScore() {
    Car car = new Car("test");
    car.move();

    car.addScore(3);
    assertEquals(4, car.getScore());
  }

  @Test
  void showPosition() {
    Car car = new Car("test", 3);
    assertEquals("---", car.showPosition("-"));
  }
}
