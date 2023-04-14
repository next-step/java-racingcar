import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임 생성")
    void 레이싱게임생성() {
        RacingGame racingGame = new RacingGame(3, 5);

        assertThat(racingGame.getNumberOfCars()).isEqualTo(3);
        assertThat(racingGame.getNumberOfRounds()).isEqualTo(5);
    }

    @Test
    @DisplayName("라운드 실행")
    void 라운드실행() {
        RacingGame racingGame = new RacingGame(3, 5);

        racingGame.runRound();

        assertThat(racingGame.getCurrentRoundCount()).isEqualTo(1);

    }
}

