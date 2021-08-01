package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void getMove() {

        int range = 10;
        Car car = new Car("myCar");
        assertThat(car.getMove(range)).isBetween(0,range);
    }

    @Test
    public void moveCar() {

        int range = 10;
        Car car = new Car("myCar");
        car.moveCar(range);

        assertThat(car.getCurrentLocation()).isNotEqualTo(0);
    }

}
