package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("자동차 수가 1 미만이면 예외 발생")
    @Test
    void carCountValidation() {
        assertThatThrownBy(() -> new RaceGame(0, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 대수");
    }

    @DisplayName("게임 횟수가 1 미만이면 예외 발생")
    @Test
    void gameCountValidation() {
        assertThatThrownBy(() -> new RaceGame(3, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 횟수");
    }

    @DisplayName("경기가 실행된다")
    @Test
    void playRaceGame() {
        RaceGame raceGame = new RaceGame(2, 3);
        raceGame.playGame();
        for (Car car : raceGame.cars()) {
            assertThat(car.position()).isBetween(0, 3);
        }
    }
}
