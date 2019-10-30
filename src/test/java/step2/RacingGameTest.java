package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @DisplayName("car 개수가 조건대로 생성이 되었는지 확인")
    @Test
    void doGameCarSizeTest() {
        RacingGame racingGame = new RacingGame(2, 5);
        List<Car> carList = racingGame.doGame();

        assertThat(carList.size()).isEqualTo(2);
    }

    @DisplayName("doGame 후 position개수와 위치가 맞는지 확인")
    @Test
    void doGamePositionTest() {
        RacingGame racingGame = new RacingGame(2, 5);
        List<Car> carList = racingGame.doGame();

        assertThat(carList.get(0).getCarPosition(0)).isBetween(0,1);
        assertThat(carList.get(0).getCarPosition(1)).isBetween(0,2);
        assertThat(carList.get(0).getCarPosition(2)).isBetween(0,3);
        assertThat(carList.get(0).getCarPosition(3)).isBetween(0,4);
        assertThat(carList.get(0).getCarPosition(4)).isBetween(0,5);

        assertThatThrownBy(()->{
            carList.get(0).getCarPosition(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

}