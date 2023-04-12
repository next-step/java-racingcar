package step3.integration;

import org.junit.jupiter.api.Test;
import step3.CarGame;

public class CarGameTest {


    @Test
    void name() {
        CarGame carGame = new CarGame(3,5);

        carGame.start();
    }
}
