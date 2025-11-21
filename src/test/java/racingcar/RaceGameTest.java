package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceGameTest {

    @DisplayName("경주 게임 객체를 생성한다")
    @Test
    void createRaceGame() {
        List<String> carNames = List.of("car1", "car2", "car3");
        int gameCount = 3;
        RaceGame raceGame = new RaceGame(carNames, gameCount);
        assertThat(raceGame.cars().allCars()).hasSize(carNames.size());
        assertThat(raceGame.gameCount().asInt()).isEqualTo(gameCount);
    }

    @DisplayName("자동차 수가 1 미만이면 예외 발생한다")
    @Test
    void carCountValidation() {
        assertThatThrownBy(() -> new RaceGame(List.of(), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 대수");
    }

    @DisplayName("중복된 이름이면 예외 발생한다")
    @Test
    void carNameDuplicateValidation() {
        assertThatThrownBy(() -> new RaceGame(List.of("car1", "car1"), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("우승자를 구한다")
    @Test
    void getSingleWinner() {
        Car a = new Car(new CarName("car1"), new Position(3));
        Car b = new Car(new CarName("car2"), new Position(2));
        RaceGame raceGame = new RaceGame(List.of(a, b), new GameCount(3));
        List<CarName> winners = raceGame.getWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly(new CarName("car1"));
    }

    @DisplayName("공동 우승자를 구한다")
    @Test
    void getMultipleWinners() {
        RaceGame raceGame = new RaceGame(List.of("car1", "car2"), 3);
        List<CarName> winners = raceGame.getWinners();
        assertThat(winners).hasSize(2)
                .containsExactly(new CarName("car1"), new CarName("car2"));
    }
}
