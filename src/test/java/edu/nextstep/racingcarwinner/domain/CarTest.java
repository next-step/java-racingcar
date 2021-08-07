package edu.nextstep.racingcarwinner.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void create() {
        // given
        String name = "hwan";

        // when
        Car car = new Car("hwan");

        // then
        assertThat(car).isEqualTo(new Car("hwan", 0));
    }

    @Test
    void moveSuccess() {
        // given
        String name = "hwan";
        Car car = new Car(name);
        // when
        car.move(4);

        // then
        assertThat(car.getName()).isEqualTo("hwan");
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void moveFail() {
        // given
        String name = "hwan";
        Car car = new Car(name);

        // when
        car.move(3);

        // then
        assertThat(car.getName()).isEqualTo("hwan");
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
