package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 테스트")
class RacingGameTest {

    int carCnt = 3;
    RacingGame racingGame = new RacingGame(carCnt);

    @DisplayName("getCarList()")
    @Test
    void getCarList() {
        assertThat(racingGame.getCarList()).isInstanceOf(CarList.class);
    }
}
