package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceGameTest {

    @DisplayName("경주 게임 객체를 생성한다")
    @Test
    void createRaceGame() {
        int carCount = 3;
        int gameCount = 3;
        RaceGame raceGame = new RaceGame(carCount, gameCount);
        assertThat(raceGame.cars()).hasSize(carCount);
        assertThat(raceGame.gameCount()).isEqualTo(gameCount);
    }
}
