package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GarageTest {
    @Test
    void 우승자_1인() {
        Car a = new Car("a", 10);
        Car b = new Car("b", 12);
        Car c = new Car("c", 13);

        Garage garage = new Garage(Arrays.asList(a, b, c));

        assertThat(garage.findWinner()).contains(c);
    }

    @Test
    void 우승자_2인() {
        Car a = new Car("a", 10);
        Car b = new Car("b", 12);
        Car c = new Car("c", 12);

        Garage garage = new Garage(Arrays.asList(a, b, c));

        assertThat(garage.findWinner()).contains(b,c);
    }

}