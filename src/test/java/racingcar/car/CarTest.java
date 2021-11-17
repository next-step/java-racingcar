package racingcar.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void hold(int input) {
        Car car = new Car();
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9,10})
    void move(int input) {
        Car car = new Car();
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}