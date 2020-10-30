package step3.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Cars;
import step3.domain.MustMoveStrategy;

import java.util.Collections;
import java.util.List;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1" , "2:2" , "3:3"} , delimiter = ':')
    @DisplayName("게임이 잘 되는지 확인한다.")
    void runGame(int carCount ,int gameRepeatCount) {

        List<Integer> carsPositions = Collections.emptyList();
        RacingGame racingGame = new RacingGame(carCount, new MustMoveStrategy());
        for (int i = 0; i < gameRepeatCount; i++) {
            Cars cars = racingGame.getGameRoundResult();
            carsPositions = cars.getCarsPosition();
        }
        carsPositions.forEach(carPosition -> Assertions.assertThat(carPosition).isEqualTo(gameRepeatCount));


    }
}