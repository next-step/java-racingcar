package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  void move() {
    Car car = new Car();
    car.move();
    car.move();
    assertEquals(2, car.getScore());
  }

  @Test
  void mergeScore() {
    Car car = new Car();
    car.move();

    car.addScore(3);
    assertEquals(4, car.getScore());
  }
}
