package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("0~9까지 랜덤 출력")
    @Test
    void random_test() {
        System.out.println(new RacingGame(3, 5).random());
    }

    @DisplayName("앞으로 전진할 수 있는가?")
    @Test
    void isGo_test() {
        RacingGame racingGame = new RacingGame(3, 5);
        String result = racingGame.isGo(racingGame.random());
        assertThat(result).isEqualTo("앞으로 이동했습니다.");

    }

    @DisplayName("Car의 객체의 Set, Get 테스트")
    @Test
    void status_car_test() {
        Car car = new Car();
        String status = "-" + "-";
        car.setLocation(status);
        assertThat(car.getLocation()).isEqualTo("--");
    }


    @DisplayName("RacingGameTest")
    @Test
    void racing_car_demo_test() {
        int cars = 3;
        int count = 5;
        RacingGame racingGame = new RacingGame(cars, count);
        List<Car> list = racingGame.settingCars(cars);
        racingGame.moveToN(list, count);
        racingGame.carStatus(list);

    }

}
