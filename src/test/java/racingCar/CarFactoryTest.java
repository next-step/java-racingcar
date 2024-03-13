package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarFactoryTest {


    @Test
    void 차_한대_생성() {
        assertThat(CarFactory.createCars(1).size()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6})
    void 차_여러대_생성(int input) {
        assertThat(CarFactory.createCars(input).size()).isEqualTo(input);
    }

}
