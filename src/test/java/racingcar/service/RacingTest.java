package racingcar.service;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.Scoreboard;

import static org.assertj.core.api.Assertions.*;



import java.util.List;

public class RacingTest {
    Racing racing = new Racing();

    @Test
    void moveCarTest(){
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        RacingCar cars = new RacingCar(List.of(car1, car2));
        Scoreboard scoreboard = new Scoreboard(cars);
        racing.moveCar(scoreboard);

        assertThat(scoreboard.getRacingCar()).isEqualTo(cars);

    }
    
}