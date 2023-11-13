package step5.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private step4.model.Car car;

    @BeforeEach
    void setUp() {
        car = Car.makeCar("test");
    }

    @ParameterizedTest(name = "random 값이 4 이상 9 이하인 경우 distance 필드를 1 증가시킵니다.")
    @ValueSource(ints = {4, 7, 9})
    void go(int randomValue) {
        // given
        // when
        car.go(randomValue);
        // then
        assertThat(car.toString()).isEqualTo("test : -");
    }

    @ParameterizedTest(name = "random 값이 0 이상 4 미만인 경우 distance 필드를 증가시키지 않습니다.")
    @ValueSource(ints = {0, 3})
    void doNotGo(int randomValue) {
        // given
        // when
        car.go(randomValue);
        // then
        assertThat(car.toString()).isEqualTo("test : ");
    }
}