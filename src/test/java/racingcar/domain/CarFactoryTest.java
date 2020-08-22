package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.CarFactory.initCars;

public class CarFactoryTest {
    @Test
    void 자동차_초기화_성공() {
        String carsName = "애플,삼성,구글";
        Cars cars = initCars(carsName);
        assertThat(cars.getSize()).isEqualTo(3);
        assertThat(cars.getCars()).containsExactly(new Car("애플"), new Car("삼성"), new Car("구글"));
    }
}
