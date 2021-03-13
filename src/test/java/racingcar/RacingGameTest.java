package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    @ParameterizedTest
    @CsvSource(value = {"0,1:1"}, delimiter = ':')
    @DisplayName("자동차 경주 게임을 완료한 후 우승자는 한 명일 수 있다.")
    void playRacingGameAndGetWinner(String positions, int winnerNumber) {
        List<Car> cars = new ArrayList();

        String[] carNames = {"pobi","jhLim"};
        String[] position = positions.split(",");

        cars.add(new Car(carNames[0], Integer.parseInt(position[0])));
        cars.add(new Car(carNames[1], Integer.parseInt(position[1])));

        Cars carGroup = new Cars(cars);

        racingGame.init(carGroup);
        racingGame.recordEachRoundPosition(1);

        assertThat(racingGame.getWinners()
                                    .getCars()
                                        .size()).isEqualTo(winnerNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1:2"}, delimiter = ':')
    @DisplayName("자동차 경주 게임을 완료한 후 우승자는 여러 명 일 수 있다.")
    void playRacingGameAndGetWinners(String positions, int winnerNumber) {
        List<Car> cars = new ArrayList();

        String[] carNames = {"pobi","jhLim"};
        String[] position = positions.split(",");

        cars.add(new Car(carNames[0], Integer.parseInt(position[0])));
        cars.add(new Car(carNames[1], Integer.parseInt(position[1])));

        Cars carGroup = new Cars(cars);

        racingGame.init(carGroup);
        racingGame.recordEachRoundPosition(1);

        assertThat(racingGame.getWinners()
                                    .getCars()
                                        .size()).isEqualTo(winnerNumber);
    }
}