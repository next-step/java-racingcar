package racing.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @Test
    void 주어진_횟수만큼_자동차생성() {
        int count = 4;
        Cars cars = CarFactory.makeCar(count);
        assertThat(cars.carSize()).isEqualTo(4);
    }
}
