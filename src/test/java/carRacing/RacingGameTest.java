package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    @DisplayName("carCount만큼 리스트를 생성한다")
    void initCarList() {
        assertThat(racingGame.initRacingCars(2)).hasSize(2);
    }

    @Test
    @DisplayName("게임의 실행결과는 전진(1) 혹은 멈춤(0)")
    void playGame() {
        racingGame.initRacingCars(2);
        racingGame.playGame();
        for (RacingCar racingCar : racingGame.getRacingCars()) {
            assertThat(racingCar.getPosition()).isBetween(0, 1);
        }
    }
}