package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.strategy.MovableNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingGameTest {

    @Test
    @DisplayName("레이싱 우승자 찾기")
    void racingResultTest(){
        Cars cars = new Cars(Arrays.asList(new Car("car1",2)
                                        , new Car("car2",3)));
        MovableNumberGenerator movableNumberGenerator = new MovableNumberGenerator();
        RacingGame racingGame = new RacingGame(movableNumberGenerator, cars ,5);

        List<String> winners = racingGame.race();

        assertAll(
                () -> assertThat(winners.contains("car2")).isTrue(),
                () -> assertThat(winners.contains("car1")).isFalse()
        );

    }

    @Test
    @DisplayName("레이싱 무승부 결과")
    void racingSameWinnerResultTest(){
        Cars cars = new Cars(Arrays.asList(new Car("car1",2)
                , new Car("car2",2)));
        MovableNumberGenerator movableNumberGenerator = new MovableNumberGenerator();
        RacingGame racingGame = new RacingGame(movableNumberGenerator, cars ,5);

        List<String> winners = racingGame.race();

        assertAll(
                () -> assertThat(winners.contains("car2")).isTrue(),
                () -> assertThat(winners.contains("car1")).isTrue()
        );

    }

}

