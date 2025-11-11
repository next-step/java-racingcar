package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

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

    @DisplayName("한 라운드에서 자동차가 고정값으로 이동한다")
    @Test
    void playRaceGame() {
        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };
        RaceGame raceGame = new RaceGame(2, 3, fixedRandom);
        raceGame.playRound();
        for (Car car : raceGame.cars()) {
            assertThat(car.position()).isEqualTo(1);
        }
    }
}
