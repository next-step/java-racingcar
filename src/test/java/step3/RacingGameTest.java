package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 테스트")
class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        int gameCnt = 3;
        racingGame = new RacingGame(gameCnt);
    }

    @DisplayName("play() 테스트")
    @Test
    void play() {
        ArrayList<Car> carList = racingGame.play();
        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i)).isInstanceOf(Car.class);
        }
    }
}
