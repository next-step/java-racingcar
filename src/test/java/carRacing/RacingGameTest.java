package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("kim,lee");
    }

    @Test
    @DisplayName("carCount만큼 리스트를 생성한다")
    void initCarList() {
        assertThat(racingGame.getRacingCars()).hasSize(2);
    }

    @Test
    @DisplayName("게임의 실행결과는 전진(1) 혹은 멈춤(0)")
    void playGame() {
        racingGame.playGame();
        for (RacingCar racingCar : racingGame.getRacingCars()) {
            assertThat(racingCar.getPosition()).isBetween(0, 1);
        }
    }

    @Test
    @DisplayName("생성된 리스트에는 이름이 존재한다")
    void initCarList_add_name() {
        List<RacingCar> racingCars = racingGame.getRacingCars();
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getName()).isNotBlank();
        }
    }

    @Test
    @DisplayName("게임이 끝나면 승자가 나온다")
    void selectWinner_greaterThan_0() {
        racingGame.playGame();
        assertThat(racingGame.selectWinner()).hasSizeGreaterThan(0);
    }

    @Test
    @DisplayName("참가자중에 승리자가 있다")
    void selectWinner_winner() {
        racingGame.playGame();
        assertThat("kim,lee").contains(racingGame.selectWinner());
    }
}