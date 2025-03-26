package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  void getName() {
    Car car = new Car("test");
    assertThat(car.getName()).isEqualTo("test");
  }

  @Test
  void move() {
    Car car = new Car("test");
    car.move();
    car.move();
    assertThat(car.getPosition()).isEqualTo(2);
  }

  @Test
  void mergeScore() {
    Car car = new Car("test");
    car.move();
    car.addScore(3);
    assertThat(car.getPosition()).isEqualTo(4);
  }

  @Test
  void showPosition() {
    Car car = new Car("test", 3);
    assertThat(car.showPosition("-")).isEqualTo("---");
  }
}
