package racingcar;

import java.util.List;

import org.junit.jupiter.api.Test;
import racingcar.RacingCar;
import racingcar.RacingCarGame;

class RacingCarGameTest {

    @Test
    void gameStart() {
        List<RacingCar> racingCars = List.of(new RacingCar("test1"), new RacingCar("test2"));
        RacingCarGame racingCarGame = new RacingCarGame(racingCars, 3);
        racingCarGame.gameStart();
    }
}