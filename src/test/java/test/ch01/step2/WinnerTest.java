package test.ch01.step2;

import ch01.racinggame.domain.Car;
import ch01.racinggame.domain.RandomNumber;
import ch01.racinggame.domain.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private Car[] cars;
    private Winner winner;

    @BeforeEach
    void setUp() {
        cars = new Car[3];
        Car car1 = new Car("tom");
        Car car2 = new Car("jerry");
        Car car3 = new Car("happy");

        RandomNumber randomNumber = new RandomNumber(){
            @Override
            public boolean movable() {
                return true;
            }
        };

        car2.move(randomNumber);
        car2.move(randomNumber);
        car2.move(randomNumber);

        car3.move(randomNumber);
        car3.move(randomNumber);
        car3.move(randomNumber);
        car3.move(randomNumber);


        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;

        winner = new Winner(cars);
    }

    @Test
    void whoAreWinners() {
        assertThat(winner.toString()).isEqualTo("happy");
    }


}