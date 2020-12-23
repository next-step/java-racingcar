package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;
    private Cars cars;

    @BeforeEach
    void setUp() {
        car = new Car();
        cars = new Cars();
    }

    @Test
    @DisplayName("자동차 전진 유무 체크")
    void moveOfCar() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 6})
    @DisplayName("차량 객체 생성 테스트 코드")
    void registerCars(int count) {
        cars.registerCar(count);
        assertThat(cars.getCars().size()).isEqualTo(count);
    }
}
