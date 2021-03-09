package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.dto.InputManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    @ParameterizedTest
    @CsvSource({"5, 0"})
    @DisplayName("주어진 횟수 동안 경주 게임을 진행할 수 있다.")
    void carsCanGoInGivenCount(int countRound, int finish) {
        String[] carNames = {"pobi","jhLim97"};
        new InputManagement(carNames, countRound);

        while (racingGame.hasNextRound()) {
            countRound--;
        }

        assertThat(countRound).isEqualTo(finish);
    }

    @ParameterizedTest
    @CsvSource("3, 1")
    @DisplayName("자동차 경주 게임을 완료한 후 우승자는 한명 이상이다.")
    void playRacingGameAndGetWinner(int countRound, int minWinnerNumber) {
        String[] carNames = {"pobi","crong","jhLim"};
        new InputManagement(carNames, countRound);

        List<Car> cars = new ArrayList();

        for (String carName : InputManagement.getCarNames()) {
            cars.add(new Car(carName, 0));
        }

        Cars carGroup = new Cars(cars);
        racingGame.startRacing(carGroup);

        assertThat(racingGame.getWinners().size()).isGreaterThanOrEqualTo(minWinnerNumber);
    }

}