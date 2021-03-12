package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("0~9까지 랜덤 출력")
    @Test
    void random_test() {
        System.out.println(new RacingCar(new Car()).random());
    }

    @DisplayName("Car의 객체의 Set, Get 테스트")
    @Test
    void status_car_test() {
        Car car = new Car();
        String status = "-" + "-";
        car.setLocation(status);
        assertThat(car.getLocation()).isEqualTo("--");
    }

    @DisplayName("전진 테스트")
    @Test
    void isGo_test() {
        RacingCar car = new RacingCar(new Car());
        String result = car.isGo(5);
        assertThat(result).isEqualTo("-");

    }

    @DisplayName("멈춤 테스트")
    @Test
    void stop_test() {
        RacingCar car = new RacingCar(new Car());
        String result = car.isGo(3);
        assertThat(result).isEqualTo("");

    }


    @DisplayName("1대의 차가 2회 움직일 경우")
    @Test
    void one_car_moves_twice_test() {
        int cars = 1;
        int count = 2;

        RacingGame racingGame = new RacingGame(cars, count);
        List<RacingCar> list = racingGame.settingRacingCars(cars);
        racingGame.gameStart(list, count);

    }

    @DisplayName("2대의 차가 1회 움직일 경우")
    @Test
    void two_car_moves_once_test() {
        int cars = 2;
        int count = 1;

        RacingGame racingGame = new RacingGame(cars, count);
        List<RacingCar> list = racingGame.settingRacingCars(cars);
        racingGame.gameStart(list, count);

    }

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @Test
        void cars_can_moves_given_number_test() {
        int cars = 3;
        int count = 5;

        RacingGame racingGame = new RacingGame(cars, count);
        List<RacingCar> list = racingGame.settingRacingCars(cars);
        racingGame.gameStart(list, count);
    }

}
