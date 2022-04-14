package racingcar;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {
    @ParameterizedTest
    @Order(1)
    @ValueSource(ints = {-1, 10})
    void 경주환경_범위에_해당되지_않은_범위를_입력_받았을때(int condition) {
        Car car = new Car("test");
        assertThatThrownBy(() -> car.move(condition))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @Order(2)
    @CsvSource({"4,9"})
    void 경주중_자동차가_이동하는_경우(int condition) {
        Car car = new Car("test");
        Car racingCar = new Car("test",1);
        car.move(condition);
        assertThat(car.isEqualPosition(racingCar)).isTrue();
    }

    @ParameterizedTest
    @Order(3)
    @ValueSource(ints = {0, 3})
    void 경주중_자동차가_멈춰있는_경우(int condition) {
        Car car = new Car("test");
        Car racingCar = new Car("test",0);
        car.move(condition);
        assertThat(car.isEqualPosition(racingCar)).isTrue();
    }
}