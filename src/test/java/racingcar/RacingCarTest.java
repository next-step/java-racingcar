package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("n대의 차 생성")
    void createcars(){
        int carCount = 3;
        List<Car> cars = racingCar.createCars(carCount);
        assertThat(cars.size()).isEqualTo(carCount);
    }

    @Test
    @DisplayName("자동차 전진 또는 멈춤")
    void moveCarTest(){
        Car car = new Car();
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(2);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("random값에 의한 전진 테스트")
    void randomTest(){
        Car car = new Car();
        int randomNumber = 4;
        boolean move = car.isMove(randomNumber);
        int randomNumber1 = 0;
        boolean stop = car.isMove(randomNumber1);

        assertThat(move).isTrue();
        assertThat(stop).isFalse();
    }

    @Test
    @DisplayName("게임 시작")
    void playTest(){
        racingCar.play(3,5);
    }
}
