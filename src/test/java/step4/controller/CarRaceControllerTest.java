package step4.controller;

import org.junit.jupiter.api.Test;
import step4.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceControllerTest {

    @Test
    void 경기를_시작한다() {
        CarRaceController controller = new CarRaceController();
        Cars testCars = controller.start();

        assertThat(testCars).isNotNull();
    }
}
