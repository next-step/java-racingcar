package test.ch01.step2;


import ch01.racinggame.Domain.Car;

import ch01.racinggame.Domain.RandomNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Test"){

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

    }


    @Test
    @DisplayName("진행막대를 보여주는 막대기")
    void showProgress() {
        //then
        assertThat(car.toString().equals("-")).isTrue();
    }

    @Test
    void showProgressCnt() {
        //given
        car.move();
        //when
        int progressCnt = car.progressCnt();
        //then
        assertThat(progressCnt).isEqualTo(2);
    }

    @Test
    void move() {
        //when
        car.move();
        //then
        assertThat(car.progressCnt()).isEqualTo(2);
    }
}