package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CarTest {

    @Test
    public void getMove() {
        Car car = new Car();
        assertThat(car.getMove()).isBetween(0,10);
    }

    @Test
    public void moveCar() {
        assertThatCode(() -> {
            Car car = new Car();
            car.moveCar();
        }).doesNotThrowAnyException();
    }

}
