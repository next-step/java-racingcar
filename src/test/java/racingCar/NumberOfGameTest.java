package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.NumberOfGame;

import static org.assertj.core.api.Assertions.*;

public class NumberOfGameTest {
    @Test
    void 입력값확인() {
        NumberOfGame numberOfGame = new NumberOfGame(5);
        assertThat(numberOfGame.checkNumberOfGame(5)).isTrue();
    }

    @Test
    void 진행횟수확인() {
        NumberOfGame numberOfGame = new NumberOfGame(5);
        for (int i = 0; i < 5; i++) {
            numberOfGame.decreaseNumberOfGame();
        }
        assertThat(numberOfGame.isEndGame()).isTrue();

    }
}
