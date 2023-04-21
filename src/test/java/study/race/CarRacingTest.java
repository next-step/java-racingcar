package study.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.calculator.Calculator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarRacingTest {

    @Test
    @DisplayName("자동차 배열 생성 확인")
    void sizeTest(){
        assertThat(CarRacing.carArray(3).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 전진, 멈춤 구현")
    void moveTest(){

        Car car = new Car();

        assertThat(car.condition(3)).isEqualTo(0);
        assertThat(car.condition(4)).isEqualTo(1);
    }

    /*@Test
    @DisplayName("경주 구현")
    void racingCount(){

        int testCarNumber = 3;
        List<Car> testCars = new Car[testCarNumber];

        assertThat(CarRacing.race(3, testCars,5 )).isEqualTo(1);
    }*/


}
