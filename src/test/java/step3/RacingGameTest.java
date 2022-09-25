package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {


    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void racing_종료_테스트(int remainTryCnt, boolean expected){
        MoveStrategy moveStrategy = () -> false;
        RacingGame racingGame = new RacingGame(3, remainTryCnt);

        racingGame.race(moveStrategy);

        assertThat(racingGame.isEnd()).isEqualTo(expected);
    }

    @Test
    void 결과_조회(){
        List<Car> cars = Arrays.asList(Car.withPosition(3), Car.withPosition(2), Car.withPosition(4));
        RacingGame racingGame = new RacingGame(cars, 0);

        assertThat(racingGame.currentPositions()).containsExactly(3, 2, 4);
    }




}
