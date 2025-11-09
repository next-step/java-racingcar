package study.racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameTest {

    @Test
    void 게임생성시_자동차_수만큼_자동차가_생성된다() {
        RacingGame racingGame = new RacingGame(3);
        List<Car> cars = racingGame.getCars();
        assertEquals(3, cars.size());
    }

    @Test
    void 게임생성시_생성된_자동차의_초기위치는_모두0이다() {
        RacingGame racingGame = new RacingGame(3);
        List<Car> cars = racingGame.getCars();
        assertEquals(0, cars.get(0).getPosition());
        assertEquals(0, cars.get(1).getPosition());
        assertEquals(0, cars.get(2).getPosition());
    }

    @Test
    void 라운드를_진행하면_모든자동차_이동을_시도한다() {
        RacingGame racingGame = new RacingGame(3);
        racingGame.playRound();

        List<Car> cars = racingGame.getCars();
        assertTrue(cars.get(0).getPosition() >= 0);
        assertTrue(cars.get(1).getPosition() >= 0);
        assertTrue(cars.get(2).getPosition() >= 0);
    }


}
