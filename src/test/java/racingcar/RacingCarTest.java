package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Garage;
import racingcar.model.Racing;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void 차_생성() {
        Garage.createCars(3);

        assertThat(Garage.cars.length).isEqualTo(3);
    }

    @Test
    void 차생성_및_전진() {
        Garage.createCars(3);
        Racing.game(3);

        assertThat(Garage.cars[0].getMoveCount()).isEqualTo(3);
    }

}