package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racing_game.controller.Simulator;
import racing_game.core.Positive;
import racing_game.core.SnapShot;

class SimulatorTest {

  @Test
  void create() {
    Positive carCount = Positive.of(3);
    Positive tryCount = Positive.of(4);
//    Simulator simulator = Simulator.create(SimulationConfig.create(carCount, tryCount));
//    assertThat(simulator).isNotNull();
//    assertThat(simulator.getCars().size()).isEqualTo(3);
//    assertThat(simulator.getTryCount()).isEqualTo(4);
  }

  @Test
  void simulate() {
    Positive carCount = Positive.of(3);
    Positive tryCount = Positive.of(4);
//    Simulator simulator = Simulator.create(SimulationConfig.create(carCount, tryCount));
//    SnapShot result = simulator.simulate();
//    assertThat(result).hasSize(4);
  }
}
