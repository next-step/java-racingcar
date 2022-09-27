package racing.controller;

import org.junit.jupiter.api.Test;
import racing.controller.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    @Test
    void 자동차_3대를_생성하면_정상적으로_3대가_생성되는지() {
        assertThat(new RacingGame().generateCar(3).size()).isEqualTo(3);
    }
}
