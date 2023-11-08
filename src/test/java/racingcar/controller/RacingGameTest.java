package racingcar.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;

public class RacingGameTest {
    @ParameterizedTest
    @DisplayName("입력받은 횟수 만큼 racing 수행 후 종료 확인")
    @CsvSource(value = {"1,2"})
    void racingGame_종료확인(int input1, int input2){
        RacingGame racingGame = new RacingGame(input1, input2);
        Cars cars = racingGame.initRacing();
        for(int i=0; i<input2; i++) {
            racingGame.start();
        }
        assertThat(racingGame.isEndGame()).isEqualTo(true);
    }
}
