package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Racing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    void 차_생성() {
        Racing racing = new Racing();

        List<Car> cars = racing.ready(3);

        assertThat(cars).hasSize(3);
    }
}