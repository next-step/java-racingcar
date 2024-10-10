package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void 차_생성() {
        assertThat(CarFactory.createCars("a,b,c"))
                .hasSize(3);
    }
}