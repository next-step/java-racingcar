package step3.integration;

import org.junit.jupiter.api.Test;
import step3.game.CarGame;

public class CarGameTest {


    @Test
    void 자동차_게임_통합테스트() {
        CarGame carGame = new CarGame(10,20);
        carGame.start();
    }
}
