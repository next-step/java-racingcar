package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Garage;

import static org.assertj.core.api.Assertions.assertThat;

class GarageTest {

    @Test
    void 차_생성() {
        Garage.createCars(3);

        assertThat(Garage.cars.length).isEqualTo(3);
    }
}