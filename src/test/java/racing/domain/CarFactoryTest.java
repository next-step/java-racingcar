package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.AlwaysMovingStrategy;
import racing.domain.car.Car;
import racing.domain.car.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"띠띠", "빵빵", "뚜뚜"})
    void 자동차_생성(String carName) {
        CarFactory carFactory = new CarFactory(new AlwaysMovingStrategy());
        Car car = carFactory.create(carName);

        assertThat(car).isEqualTo(new Car(new AlwaysMovingStrategy(), carName));
    }

    @Test
    void 자동차_다중_생성() {
        CarFactory carFactory = new CarFactory(new AlwaysMovingStrategy());
        List<Car> car = carFactory.create("띠띠", "빵빵", "뚜뚜");

        assertThat(car)
            .hasSize(3)
            .containsExactly(
                new Car(new AlwaysMovingStrategy(), "띠띠"),
                new Car(new AlwaysMovingStrategy(), "빵빵"),
                new Car(new AlwaysMovingStrategy(), "뚜뚜")
            );
    }

}