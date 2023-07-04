package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RacingManagerTest {

    @Test
    @DisplayName("라운드 횟수만큼 Cars 에게 게임 수행 메세지를 전달한다.")
    public void 라운드_횟수만큼_Cars_에게_게임_수행_메세지를_전달한다() throws Exception {
        int round = 3;
        Cars cars = Mockito.mock(Cars.class);
        RacingManager racingManager = new RacingManager(cars, round);

        racingManager.play();

        Mockito.verify(cars, Mockito.times(3)).takeTurn();
    }

}
