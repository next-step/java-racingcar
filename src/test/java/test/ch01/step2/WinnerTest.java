package test.ch01.step2;

import ch01.racinggame.Domain.Car;
import ch01.racinggame.Domain.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private Car[] cars;
    private Winner winner;


    @BeforeEach
    void setUp() {
        cars = new Car[3];
        Car car1 = new Car("tom"){

            private int progressCnt = 1;

            @Override
            public int progressCnt() {
                return this.progressCnt;

            }

            @Override
            public void move() {
                progressCnt++;
            }
        };
        Car car2 = new Car("jerry"){

            private int progressCnt = 1;

            @Override
            public int progressCnt() {
                return this.progressCnt;

            }

            @Override
            public void move() {
               this.progressCnt++;
            }
        };
        Car car3 = new Car("happy"){

            private int progressCnt = 1;

            @Override
            public int progressCnt() {
                return this.progressCnt;

            }

            @Override
            public void move() {
                progressCnt++;
            }
        };

        car2.move();
        car2.move();
        car2.move();

        car3.move();
        car3.move();
        car3.move();
        car3.move();


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