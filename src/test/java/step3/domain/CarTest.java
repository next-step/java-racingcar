package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

  private Car car;

  @BeforeEach
  void before() {
    car = new Car("name");
  }

  @DisplayName("객체 생성 확인")
  @Test
  void constructorTest() {
    assertThat(car.getDistance()).isEqualTo(1);
    assertThat(car.getName()).isEqualTo("name");
  }

  @DisplayName("이동할 수 있는지 확인")
  @Test
  void canMoveTest() {
    car.move(5);
    assertThat(car.getDistance()).isEqualTo(2);
  }

  @DisplayName("이동할 수 없는지 확인")
  @Test
  void cannotMoveTest() {
    car.move(1);
    assertThat(car.getDistance()).isEqualTo(1);
  }

}
