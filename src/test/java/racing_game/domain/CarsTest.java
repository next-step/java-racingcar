package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

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

    assertThat(cars.getDistances()).extracting("holder").containsAnyOf(0, 1);
  }
}
