package study;

import CarRacing.Car;
import CarRacing.Cars;
import CarRacing.CarRacing;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class CarRacingTest {


    @Test
    @DisplayName("자동차 전진테스트")
    void carMove() {
        Car car = new Car();
        car.move();
        assertTrue(car.getCarPosition() == 0 || car.getCarPosition() == 1);
    }

    @Test
    @DisplayName("자동차 대수 입력받고 자동차 대수 확인.")
    void insertCarAndGetCarCount() {
        Cars carList = new Cars(5);
        assertThat(carList.getCars().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차레이싱 테스트")
    void carRacing() {
        CarRacing carRacing = new CarRacing(new Cars(5));
        carRacing.moveCars();
        Cars cars = carRacing.getCars();
        cars.getCars().forEach(s -> assertTrue(s.getCarPosition() == 0 || s.getCarPosition() == 1));
    }


    @Test
    @DisplayName("자동차레이싱 문자열 출력")
    void carRacingPrintString() {
        CarRacing carRacing = new CarRacing(new Cars(5));
        carRacing.moveCars();
        Cars cars = carRacing.getCars();
        cars.getCars().forEach(s -> assertTrue(s.getCarPosition() == 0 || s.getCarPosition() == 1));
    }


}

