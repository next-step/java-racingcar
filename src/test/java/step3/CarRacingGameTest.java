package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingGameTest {

    @Test
    void play() {
        CarRacingGame game = new CarRacingGame("pobi,crong,honux");
        assertThatThrownBy(() -> game.play(0)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("최소 한 번이상 시도해야합니다.");
    }
}
