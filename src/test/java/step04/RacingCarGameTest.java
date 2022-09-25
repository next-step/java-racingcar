package step04;

import java.util.List;

import org.junit.jupiter.api.Test;
import step4.RacingCar;
import step4.RacingCarGame;

class RacingCarGameTest {

    @Test
    void gameStart() {
        List<RacingCar> racingCars = List.of(new RacingCar("test1"), new RacingCar("test2"));
        RacingCarGame racingCarGame = new RacingCarGame(racingCars, 3);
        racingCarGame.gameStart();
    }
}