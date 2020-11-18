package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void create_racing_game_instance() {
        racingGame = new RacingGame();
    }

    @Test
    @DisplayName("자동차수 입력받기")
    void input_number_of_cars() {
        racingGame.startGame();
    }

}