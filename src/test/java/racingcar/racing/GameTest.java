package racingcar.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @DisplayName("초기 세팅 테스트")
    @Test
    public void createGame() {
        Game game = new Game(5);

        assertThat(game.getCars())
                .allMatch(car -> car.getPosition()==0);

        assertThat(game.getStage())
                .isEqualTo(0);
    }

    @DisplayName("start 테스트")
    @Test
    public void startGame() {
        Game game = new Game(5);

        for (int i = 0; i < 10; i++) {
            game.start();

            assertThat(game.getStage()).isEqualTo(i + 1);
        }

        assertThat(game.getCars())
                .allMatch(car -> car.getPosition() <= 10);
    }
}