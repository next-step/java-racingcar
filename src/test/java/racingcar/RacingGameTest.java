package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    @ParameterizedTest
    @CsvSource({"3, 5"})
    @DisplayName("초기화가 정상적으로 이뤄지는지 확인한다.")
    void initRacing(int countCar, int countTry) {
        racingGame.initRacing(countCar, countTry);
        assertThat(racingGame.preparedRacingCars().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource({"3, 0"})
    @DisplayName("주어진 횟수 동안 경주 게임을 진행할 수 있다.")
    void carsCanGoInGivenCount(int countRound, int finish) {
        racingGame.setPlusCountRound(countRound);

        while (racingGame.hasNextRound()) {
            racingGame.playRacing();

            countRound--;
        }

        assertThat(countRound).isEqualTo(finish);
    }
}