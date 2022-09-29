package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("4이상의 숫자가 들어오면 전진")
    void carMove(){
        Car car = new Car();
        car.move(5);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }
}
