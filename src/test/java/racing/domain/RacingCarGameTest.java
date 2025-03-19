package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.config.GameConfig;
import racing.util.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @Test
    @DisplayName("자동차 게임이 올바른 개수의 자동차로 초기화된다")
    void initializeWithCorrectNumberOfCars() {
        String[] carNames = new String[] {"Tesla", "BMW", "Audi"};
        RacingCarGame racingCarGame = new RacingCarGame(new GameConfig(carNames, 1));

        assertThat(racingCarGame.getCars()).hasSize(carNames.length);
    }

    @Test
    @DisplayName("경주가 지정된 라운드 수만큼 실행된다")
    void startRaceExecutesCorrectNumberOfRounds() {
        int numberOfRounds = 10;
        String[] carNames = new String[] {"Tesla", "BMW", "Audi"};
        RacingCarGame racingCarGame = new RacingCarGame(new GameConfig(carNames, numberOfRounds));
        racingCarGame.startRace();

        assertThat(racingCarGame.getResult()).hasSize(numberOfRounds);
    }

    @Test
    @DisplayName("자동차는 기준값 이상일 때만 이동한다")
    void carsOnlyMoveWhenAboveThreshold() {
        int numberOfRounds = 1;
        String[] carNames = new String[] {"Tesla", "BMW", "Audi"};
        GameConfig gameConfig = new GameConfig(carNames, numberOfRounds);
        NumberGenerator alwaysForwardGenerator = () -> 5;
        RacingCarGame racingCarGame = new RacingCarGame(gameConfig, alwaysForwardGenerator);

        racingCarGame.startRace();
        for (Car car : racingCarGame.getCars()) {
            assertThat(car.getPosition()).isEqualTo(numberOfRounds+1);
        }
    }

    @Test
    @DisplayName("자동차는 기준값 미만일 때 이동하지 않는다")
    void carsDoNotMoveWhenBelowThreshold() {
        int numberOfRounds = 1;
        String[] carNames = new String[] {"Tesla", "BMW", "Audi"};
        GameConfig gameConfig = new GameConfig(carNames, numberOfRounds);
        NumberGenerator alwaysStayGenerator = () -> 3;
        RacingCarGame racingCarGame = new RacingCarGame(gameConfig, alwaysStayGenerator);

        racingCarGame.startRace();
        for (Car car : racingCarGame.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("가장 멀리 간 자동차가 우승자가 된다.")
    void getWinners_shouldReturnCarWithMaxPosition() {
        int numberOfRounds = 1;
        String[] carNames = new String[] {"Tesla", "BMW", "Audi"};
        GameConfig gameConfig = new GameConfig(carNames, numberOfRounds);
        NumberGenerator alwaysForwardGenerator = () -> 5;
        RacingCarGame racingCarGame = new RacingCarGame(gameConfig, alwaysForwardGenerator);

        racingCarGame.startRace();
        assertThat(racingCarGame.getWinners())
                .hasSize(3)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("Tesla", "BMW", "Audi");
    }
}
