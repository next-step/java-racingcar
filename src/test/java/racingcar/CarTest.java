package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private final Car car = new Car();
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Test
    @DisplayName("car_race_동작_테스트")
    public void race_test() {
        car.race(5);
        assertThat(car.getDistance()).isGreaterThan(0);
    }

}
