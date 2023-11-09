package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @ParameterizedTest
    @DisplayName("입력받은 횟수 만큼 racing 수행 후 종료 확인")
    @CsvSource(value = {"1,2"})
    void racingGame_종료확인(int input1, int input2){
        RacingGame racingGame = new RacingGame(input1,input2);
        for(int i=0; i<input2; i++) {
            racingGame.start();
        }
        assertThat(racingGame.isEndGame()).isEqualTo(true);
    }
    @ParameterizedTest
    @DisplayName("입력받은 자동차 대수 만큼 Cars 생성하는 지 확인")
    @CsvSource(value = {"1,2"})
    void racingGame_CarsSize확인(int input1, int input2){
        RacingGame racingGame = new RacingGame(input1,input2);
        Cars cars = racingGame.initRacing(input1);
        assertThat(cars.carList().size()).isEqualTo(1);
    }
}
