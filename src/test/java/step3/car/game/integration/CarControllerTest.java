package step3.car.game.integration;

import org.junit.jupiter.api.Test;
import step3.controller.CarController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class CarControllerTest {


    @Test
    void 자동차_게임_통합테스트() {
        String[] carNames = new String[]{"benz","bmw","audi"};

        assertThatCode(() -> {
            CarController carController = new CarController(carNames,20);
            carController.start();
        }).doesNotThrowAnyException();
    }
}
