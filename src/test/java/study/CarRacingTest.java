package study;

import CarRacing.Car;
import CarRacing.CarRacing;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

public class CarRacingTest {


    @Test
    @DisplayName("자동차 전진테스트 4이상의 값일때만")
    void carMoving() {
        Car car = new Car();
        car.carMove(4);
        Assertions.assertThat(car.getCarMovingDistance().toString()).isEqualTo("-");
    }


    @Test
    @DisplayName("자동차 경주 테스트")
    void carRaicing() {
        CarRacing carRacing = new CarRacing(5, 5);
        carRacing.raceStart();
    }

}
