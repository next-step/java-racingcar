package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void before() {
        car = new Car();
    }

    @Test
    @DisplayName("Car 객체 생성 시 position은 0")
    void Car_constructor() {
        assertThat(car.hasPosition(0)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("파라미터와 position 동치 비교")
    void hasPosition(int input) {
        for (int i = 0; i < input; i++) {
            car.forward();
        }
        assertThat(car.hasPosition(input)).isTrue();
        assertThat(car.hasPosition(input+1)).isFalse();
    }

    @Test
    @DisplayName("forward() 호출 시 position 1 증가")
    void forward() {
        int startPosition = 0;
        assertThat(car.hasPosition(startPosition)).isTrue();
        car.forward();
        assertThat(car.hasPosition(startPosition + 1)).isTrue();
    }

}