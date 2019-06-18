package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("postion 값 셋팅 테스트(처음 position 무조건 1로 셋팅)")
    void firstMoveTest() {
        int carNumber = 3;
        RacingGame racingGame = new RacingGame(carNumber);
        List<Car> carPositionList = racingGame.move();
        for(Car car : carPositionList){
            assertThat(car.lastCarPosition()).isEqualTo(1);
        }
    }


}
