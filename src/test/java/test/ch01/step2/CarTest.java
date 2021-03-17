package test.ch01.step2;

import ch01.step2.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
        car.setProgressCnt(1);
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
        car.setProgressCnt(2);
        //when
        int progressCnt = car.getProgressCnt();
        //then
        assertThat(progressCnt).isEqualTo(2);
    }

    @Test
    void move() {

        //give
        int currentStepCnt = car.getProgressCnt();

        //when
        car.setProgressCnt(currentStepCnt + 1);

        //then
        assertThat(car.getProgressCnt()).isEqualTo(currentStepCnt + 1);
    }
}