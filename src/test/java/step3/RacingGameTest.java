package step3;


import calculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.car.Car;
import racingcar.racinggame.RacingGame;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void makeCarTestFunction() {
        racingGame.makeCar(3);
        int carCount = racingGame.getCars().size();
        assertThat(carCount).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 생성 테스트")
    void racingGameCountTestFunction() {
        racingGame.setGameCount(6);
        int gameCount = racingGame.getGameCount();
        assertThat(gameCount).isEqualTo(6);
    }

    @Test
    @DisplayName("게임 종료 테스트")
    void racingGameIsEndTestFunction() {
        racingGame.makeCar(3);
        int gameCount = 5;
        racingGame.setGameCount(gameCount);
        for(int i = 0; i < gameCount; i++){
            racingGame.play();
        }

        boolean isEnd = racingGame.isEnd();
        assertThat(isEnd).isEqualTo(true);
    }

    @Test
    @DisplayName("레이싱 게임 자동차 위치 표출 테스트")
    void racingGameCarSymbolTestFunction() {
        String symbol = "";

        racingGame.makeCar(1);
        racingGame.setGameCount(5);
        ArrayList<Car> cars = racingGame.getCars();
        int carMoving = cars.get(0).getPosition();

        for(int i = 0; i < carMoving; i++){
            symbol = symbol.concat("-");
        }

        assertThat(symbol).isEqualTo(racingGame.getCarTraceSymbolByCar(cars.get(0)));
    }
}
