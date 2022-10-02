package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {


    @Test
    @DisplayName("생성된 자동차의 개수")
    void carCount(){
        RacingGame racingGame = new RacingGame();
        assertThat(racingGame.makeCarList(5)).hasSize(5);
    }

    @Test
    @DisplayName("시도한 횟수")
    void tryCount(int count){
        /* 요부분은 고민하고있습니다 ㅜㅜ..*/
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4,5})
    @DisplayName("4이상의 숫자가 들어오면 전진")
    void carMove(int number){
        Car car = new Car();
        car.move(number);
        assertThat(car.getMoveCount()).isEqualTo(2);
    }
}
