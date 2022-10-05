package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"띠띠", "빵빵", "뚜뚜"})
    void 자동차_생성(String carName) {
        CarFactory carFactory = new CarFactory(new AlwaysMovingRule());
        Car car = carFactory.create(carName);

        assertThat(car).isEqualTo(new Car(new AlwaysMovingRule(), carName));
    }

    @Test
    void 자동차_다중_생성() {
        CarFactory carFactory = new CarFactory(new AlwaysMovingRule());
        List<Car> car = carFactory.create("띠띠", "빵빵", "뚜뚜");

        assertThat(car)
            .hasSize(3)
            .containsExactly(
                new Car(new AlwaysMovingRule(), "띠띠"),
                new Car(new AlwaysMovingRule(), "빵빵"),
                new Car(new AlwaysMovingRule(), "뚜뚜")
            );
    }

}