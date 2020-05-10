package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void moveTest(){
        Car car = new Car();
        int expected = 1;

        car.move();

        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
