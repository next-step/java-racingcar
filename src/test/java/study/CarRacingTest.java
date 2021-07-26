package study;

import CarRacing.Car;
import CarRacing.CarList;
import CarRacing.CarRacing;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class CarRacingTest {


    @Test
    @DisplayName("자동차 전진테스트 4이상의 값일때만")
    void carMoveIfFourOver() {
        Car car = new Car();
        car.move(4);
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차를 리스트에 추가하고 자동차대수 받기")
    void insertCarAndGetCarCount() {
        CarList carList = new CarList();
        carList.addCarCount(5);
        assertThat(carList.getCarList().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차들 전진유무 확인")
    void checkCarListMove() {
        CarRacing carRacing = new CarRacing(5);
        carRacing.moveCarList();
        carRacing.getCarList().forEach(s -> assertTrue(s.getCarPosition() == 0 || s.getCarPosition() == 1));
    }
}

