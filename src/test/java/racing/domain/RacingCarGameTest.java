package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.config.GameConfig;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @Test
    @DisplayName("자동차 게임이 올바른 개수의 자동차로 초기화된다")
    void initializeWithCorrectNumberOfCars() {
        Cars cars = new Cars(new String[] {"Tesla", "BMW", "Audi"});
        GameConfig gameConfig = new GameConfig(cars, 1);
        RacingCarGame racingCarGame = new RacingCarGame(gameConfig);

        assertThat(racingCarGame.getCars()).hasSize(cars.getAll().size());
    }

    @Test
    @DisplayName("경주가 지정된 라운드 수만큼 실행된다")
    void startRaceExecutesCorrectNumberOfRounds() {
        int numberOfRounds = 10;
        Cars cars = new Cars(new String[] {"Tesla", "BMW", "Audi"});
        GameConfig gameConfig = new GameConfig(cars, numberOfRounds);
        RacingCarGame racingCarGame = new RacingCarGame(gameConfig);

        racingCarGame.startRace();

        assertThat(racingCarGame.getResult()).hasSize(numberOfRounds);
    }

    @Test
    @DisplayName("경주가 실행된 후 우승자를 알 수 있다.")
    void getWinners_shouldReturnCarWithMaxPosition() {
        Cars cars = new Cars(new String[] {"Tesla", "BMW", "Audi"});
        GameConfig gameConfig = new GameConfig(cars, 1);
        RacingCarGame racingCarGame = new RacingCarGame(gameConfig);

        racingCarGame.startRace();

        assertThat(racingCarGame.getWinners()).isNotNull();
    }
}
