package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racing_game.core.Positive;
import racing_game.core.SimulationConfig;

class ConfigTest {

  @Test
  void create() {
    SimulationConfig simulationConfig = SimulationConfig.create(Positive.of(3), Positive.of(4));
    assertThat(simulationConfig).isNotNull();
    assertThat(simulationConfig.getCarCount()).isEqualTo(3);
    assertThat(simulationConfig.getTryCount()).isEqualTo(4);
  }
}
