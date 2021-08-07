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
        Car car = new Car(name){
            @Override
            protected int getRandomNum() {
                return 4;
            }
        };

        // when
        car.move();

        // then
        assertThat(car.getName()).isEqualTo("hwan");
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void moveFail() {
        // given
        String name = "hwan";
        Car car = new Car(name){
            @Override
            protected int getRandomNum() {
                return 3;
            }
        };

        // when
        car.move();

        // then
        assertThat(car.getName()).isEqualTo("hwan");
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
