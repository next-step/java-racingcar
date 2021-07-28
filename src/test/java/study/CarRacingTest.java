package study;

import CarRacing.Car;
import CarRacing.Cars;
import CarRacing.CarRacing;
import CarRacing.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class CarRacingTest {


    @Test
    @DisplayName("포지션 랜덤값테스트")
    void positionRandom() {
        Position position = new Position();
        position.move();
        assertTrue(position.getPosition() == 0 || position.getPosition() == 1);
    }

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
        Cars cars = new Cars(5);
        assertThat(cars.getCars().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차레이싱 시작후 문자출력 테스트")
    void carRacing() {
        CarRacing carRacing = new CarRacing(new Cars(5));
        StringBuilder sb = carRacing.moveCarsToString(5);
        assertThat(sb).contains("-");
    }

}

