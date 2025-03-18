package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.config.GameConfig;
import racing.util.NumberGenerator;
import racing.domain.RacingCarGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarGameTest {

    @Test
    @DisplayName("자동차 게임이 올바른 개수의 자동차로 초기화된다")
    void initializeWithCorrectNumberOfCars() {
        int numberOfCars = 10;
        RacingCarGame racingCarGame = new RacingCarGame(new GameConfig(numberOfCars, 1));

        assertThat(racingCarGame.getCars()).hasSize(numberOfCars);
    }

    @Test
    @DisplayName("경주가 지정된 라운드 수만큼 실행된다")
    void startRaceExecutesCorrectNumberOfRounds() {
        int numberOfRounds = 10;
        RacingCarGame racingCarGame = new RacingCarGame(new GameConfig(3, numberOfRounds));
        racingCarGame.startRace();

        assertThat(racingCarGame.getResult()).hasSize(numberOfRounds);
    }

    @Test
    @DisplayName("자동차는 기준값 이상일 때만 이동한다")
    void carsOnlyMoveWhenAboveThreshold() {
        int numberOfRounds = 1;
        GameConfig gameConfig = new GameConfig(3, numberOfRounds);
        NumberGenerator alwaysForwardGenerator = () -> 5;
        RacingCarGame racingCarGame = new RacingCarGame(gameConfig, alwaysForwardGenerator);

        racingCarGame.startRace();
        for (Car car : racingCarGame.getCars()) {
            assertEquals(numberOfRounds+1, car.getPosition());
        }
    }

    @Test
    @DisplayName("자동차는 기준값 미만일 때 이동하지 않는다")
    void carsDoNotMoveWhenBelowThreshold() {
        int numberOfRounds = 1;
        GameConfig gameConfig = new GameConfig(3, numberOfRounds);
        NumberGenerator alwaysStayGenerator = () -> 3;
        RacingCarGame racingCarGame = new RacingCarGame(gameConfig, alwaysStayGenerator);

        racingCarGame.startRace();
        for (Car car : racingCarGame.getCars()) {
            assertEquals(1, car.getPosition());
        }
    }
}
