package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceGameTest {

    @DisplayName("경주 게임 객체를 생성한다")
    @Test
    void createRaceGame() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        int gameCount = 3;
        RaceGame raceGame = new RaceGame(carNames, gameCount);
        assertThat(raceGame.cars()).hasSize(carNames.size());
        assertThat(raceGame.gameCount()).isEqualTo(gameCount);
    }

    @DisplayName("자동차 수가 1 미만이면 예외 발생")
    @Test
    void carCountValidation() {
        assertThatThrownBy(() -> new RaceGame(List.of(), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 대수");
    }

    @DisplayName("게임 횟수가 1 미만이면 예외 발생")
    @Test
    void gameCountValidation() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        assertThatThrownBy(() -> new RaceGame(carNames, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 횟수");
    }

    @DisplayName("한 라운드에서 자동차가 고정값으로 이동한다")
    @Test
    void playRaceGame() {
        List<String> carNames = Arrays.asList("car1", "car2");
        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };
        RaceGame raceGame = new RaceGame(carNames, 3, fixedRandom);
        raceGame.playRound();
        for (Car car : raceGame.cars()) {
            assertThat(car.position()).isEqualTo(1);
        }
    }

    @DisplayName("우승자를 구한다")
    @Test
    void getSingleWinner() {
        RaceGame raceGame = new RaceGame(Arrays.asList("car1", "car2"), 3);
        raceGame.cars().getFirst().moveIfPossible(4);
        List<String> winners = raceGame.getWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly("car1");
    }

    @DisplayName("공동 우승자를 구한다")
    @Test
    void getMultipleWinners() {
        RaceGame raceGame = new RaceGame(Arrays.asList("car1", "car2"), 3);
        List<String> winners = raceGame.getWinners();
        assertThat(winners).hasSize(2)
                .containsExactly("car1", "car2");
    }
}
