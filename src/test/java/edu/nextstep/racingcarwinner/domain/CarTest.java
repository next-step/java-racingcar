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
        Car car = new Car("hwan");

        // when
        car.move();

        // then
        assertThat(car).isEqualTo(new Car("hwan", 1));
    }

    @Test
    void moveFail() {
        // given
        Car car = new Car("hwan");

        // when
        car.move();

        // then
        assertThat(car).isEqualTo(new Car("hwan", 0));
    }
}
