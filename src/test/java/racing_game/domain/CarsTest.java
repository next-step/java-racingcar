package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racing_game.core.Positive;

class CarsTest {

  @Test
  void create() {
    Cars cars = Cars.create(Positive.of(3));
    assertThat(cars).isNotNull();
    assertThat(cars.size()).isEqualTo(3);
  }

  @Test
  void moveAll() {
    Cars cars = Cars.create(Positive.of(3));
    cars.moveAll();

    cars.forEach(car -> assertThat(car.getDistance(1)).isGreaterThanOrEqualTo(0));
    cars.forEach(
        car -> assertThatThrownBy(() -> car.getDistance(2)).isInstanceOf(RuntimeException.class));
  }
}
