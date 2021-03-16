package test.ch01.step2;

import ch01.step2.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
class CarTest {

    Car car;
    @BeforeEach
    void setUp(){
        car = new Car("TestCar");
        car.setProgressBar("-");
        car.setProgressCnt(1);
    }


    @Test
    @DisplayName("진행막대를 보여주는 막대깇")
    void showProgress() {
        //given
        car.setProgressBar("--");
        //when
        String progressBar = car.getProgressBar();
        //then
        assertThat(progressBar.equals("--")).isTrue();
    }

    @Test
    void showProgressCnt() {
        //given
        car.setProgressCnt(2);
        //when
        int progressCnt  = car.getProgressCnt();
        //then
        assertThat(progressCnt).isEqualTo(2);
    }

    @Test
    void move() {

        //given
        String currentStep = car.getProgressBar();
        int currentStepCnt = car.getProgressCnt();

        //when
        car.setProgressBar(currentStep+"-");
        car.setProgressCnt(currentStepCnt+1);

        //then
        assertThat(car.getProgressBar().equals(currentStep+"-"));
        assertThat(car.getProgressCnt()).isEqualTo(currentStepCnt+1);
    }
}