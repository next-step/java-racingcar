package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racing_game.core.Positive;

class SimulatorTest {

  @Test
  void create() {
    Positive carCount = Positive.of(3);
    Positive tryCount = Positive.of(4);
    Simulator simulator = Simulator.create(Config.create(carCount, tryCount));
    assertThat(simulator).isNotNull();
    assertThat(simulator.getCars().size()).isEqualTo(3);
    assertThat(simulator.getTryCount()).isEqualTo(4);
  }

  @Test
  void simulate() {
    Positive carCount = Positive.of(3);
    Positive tryCount = Positive.of(4);
    Simulator simulator = Simulator.create(Config.create(carCount, tryCount));
    simulator.simulate();
    simulator.getCars().forEach(car -> assertThat(car.getDistance(4)).isGreaterThanOrEqualTo(0));
  }
}
