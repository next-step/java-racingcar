package racing.controller;

import org.junit.jupiter.api.Test;
import racing.controller.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    @Test
    void 자동차_생성이_정상적으로_되는지() {
        assertThat(new RacingGame().generateCar(3).size()).isEqualTo(3);
    }

    @Test
    void 입력한_실행횟수만큼_돌아가는지() {

    }
}
