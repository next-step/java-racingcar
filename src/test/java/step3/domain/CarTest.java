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

  @DisplayName("Car객체 생성 시 distance 초기값이 1인지 확인한다.")
  @Test
  void initTest() {
    assertThat(car.getDistance()).isEqualTo(1);
  }

  @DisplayName("move 와 getDistance 가 잘 동작하는지 확인")
  @Test
  public void canMoveTest() {
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
