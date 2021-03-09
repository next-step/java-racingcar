package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("0~9까지 랜덤 출력")
    @Test
    void random_test() {
        System.out.println(new RacingCar(3, 5).random());
    }

    @DisplayName("앞으로 전진할 수 있는가?")
    @Test
    void isGo_test() {
        RacingCar racingCar = new RacingCar(3, 5);
        String result = racingCar.isGo(racingCar.random());
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

    @DisplayName("ResultView 테스트")
    @Test
    void resultView_test() {

        ArrayList<Car> list = new ArrayList<>();

        Car car = new Car();
        car.setLocation("---");

        Car car2 = new Car();
        car2.setLocation("----");

        Car car3 = new Car();
        car3.setLocation("-----");

        list.add(car);
        list.add(car2);
        list.add(car3);

        ResultView resultView = new ResultView();
    }

    @DisplayName("RacingCarTest")
    @Test
    void racing_car_demo_test() {
        int cars = 3;
        int count = 5;
        RacingCar racingCar = new RacingCar(cars, count);
        List<Car> list = racingCar.settingCars(cars);
        racingCar.moveToN(list, count);
        racingCar.carStatus(list);

    }

}
