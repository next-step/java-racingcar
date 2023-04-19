package step3.car.game.integration;

import org.junit.jupiter.api.Test;
import step3.controller.CarController;

public class CarControllerTest {


    @Test
    void 자동차_게임_통합테스트() {
        CarController carController = new CarController(10,20);
        carController.start();
    }
}
