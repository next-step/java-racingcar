package test.ch01.step2;

import ch01.racinggame.Domain.Car;
import ch01.racinggame.Domain.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    Car[] cars;
    Winner winner;

    @BeforeEach
    void setUp() {
        cars = new Car[3];
        Car car1 = new Car("tom");
        Car car2 = new Car("jerry");
        Car car3 = new Car("happy");

        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;

        car1.move();
        car1.move();
        car1.move();

        car2.move();
        car2.move();
        car2.move();

        car3.move();
    }

    @Test
    void whoAreWinners() {
        winner = new Winner(cars);

        winner.whoAreWinners();

        assertThat(winner.toString()).isEqualTo("tom, jerry");


    }


}