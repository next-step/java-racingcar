package step3.car.game.unit;

import org.junit.jupiter.api.Test;
import step3.controller.CarController;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class CarControllerTest {

    @Test
    void 자동차게임_생성() {
        String[] carNames = new String[]{"benz","bmw","audi"};
        int numberOfMoves = 5;

        assertThatCode(() -> new CarController(carNames, numberOfMoves))
                .doesNotThrowAnyException();
    }

    @Test
    void 랜덤숫자_생성_0이상_10미만() {
        for (int i = 0; i < 20; i++) {
            int randomNumber = new Random().nextInt(10);
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
            assertThat(randomNumber).isLessThanOrEqualTo(9);
        }
    }
}
