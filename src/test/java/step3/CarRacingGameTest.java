package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingGameTest {

    @Test
    void setCars_negative_carNum() {
        assertThatThrownBy(() -> new CarRacingGame(-5)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 대수는 자연수이어야 합니다.");
    }

    @Test
    void play() {
        CarRacingGame game = new CarRacingGame(5);
        assertThatThrownBy(() -> game.play(0)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("최소 한 번이상 시도해야합니다.");
    }
}
