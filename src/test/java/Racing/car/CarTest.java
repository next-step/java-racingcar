package Racing.car;

import static org.assertj.core.api.Assertions.assertThat;

import Racing.score.Score;
import Racing.stage.Stage;
import Racing.type.RacingNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  @DisplayName("Car 는 move 해서 거리를 추가할수 있습니다")
  void testMove() {
    // given
    Car car = new Car();
    Stage stage = new Stage();
    Score score = new Score(stage, new RacingNumber(4));
    // when
    car.move(score);
    // then
    assertThat(car.presentDistance().toString().length()).isEqualTo(4);
  }

  @Test
  @DisplayName("Car 는 Score 가 4이하이면 move의 거리가 0 입니다")
  void testMove_stop() {
    // given
    Car car = new Car();
    Stage stage = new Stage();
    Score score = new Score(stage, new RacingNumber(3));
    // when
    car.move(score);
    // then
    assertThat(car.presentDistance().toString().length()).isLessThanOrEqualTo(0);
  }
}