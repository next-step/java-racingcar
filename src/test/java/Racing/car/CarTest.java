package Racing.car;

import static org.assertj.core.api.Assertions.assertThat;

import Racing.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  @DisplayName("Car 는 move 해서 거리를 추가할수 있습니다")
  void testMove() {
    // given
    Car car = new Car();
    Stage stage = new Stage();
    // when
    car.move(stage);
    // then
    assertThat(car.presentDistance().toString().length()).isGreaterThanOrEqualTo(4);
    assertThat(car.presentDistance().toString().length()).isLessThanOrEqualTo(9);
  }
}