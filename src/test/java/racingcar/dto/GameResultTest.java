package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class GameResultTest {

    GameResult gameResult;
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void init() {
        gameResult = new GameResult();

        cars.add(Car.create("car1"));
        cars.add(Car.create("car2"));
        cars.add(Car.create("car3"));
        cars.add(Car.create("car4"));
        cars.add(Car.create("car5"));
    }

    @Test
    @DisplayName("현재 라운드에서 우승자명이 정상적으로 보여져야한다.")
    void getWinnerNameTest() {
        Car car1 = cars.get(0);
        Car car3 = cars.get(2);

        car1.forward();
        car3.forward();

        cars.forEach(car -> gameResult.record(0, car));

        assertThat(gameResult.getWinnerNames()).contains("car1", "car3");
    }

}