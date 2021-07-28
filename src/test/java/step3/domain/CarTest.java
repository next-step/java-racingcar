package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  private Car car;

  @BeforeEach
  void init() {
    car = new Car(new Name("pobi"));
  }

  @DisplayName("움직일 수 있는 조건이 true 일 때 자동차가 한 칸 움직인다.")
  @Test
  void move() {
    final int given = 4;
    car.move(new NumberMovableCondition(given));

    int actual = car.getLocation();
    assertThat(actual).isEqualTo(1);
  }

  @DisplayName("움직일 수 있는 조건이 false 일 떄 자동차는 움직이지 않는다.")
  @Test
  void stop() {
    final int given = 3;
    car.move(new NumberMovableCondition(given));

    int actual = car.getLocation();
    assertThat(actual).isEqualTo(0);
  }

}