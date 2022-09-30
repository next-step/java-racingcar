package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racing_game.core.Positive;

class ConfigTest {

  @Test
  void create() {
    Config config = Config.create(Positive.of(3), Positive.of(4));
    assertThat(config).isNotNull();
    assertThat(config.getCarCount()).isEqualTo(3);
    assertThat(config.getTryCount()).isEqualTo(4);
  }
}
