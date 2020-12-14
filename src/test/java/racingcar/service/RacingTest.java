package racingcar.service;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.Scoreboard;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
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

    @Test
    void tryToMoveTest(){
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        List<Car> list= new ArrayList<>(List.of(car1, car2));
        RacingCar cars = new RacingCar(list);
        Scoreboard board = new Scoreboard(cars);

        Racing racing = new Racing();

        racing.tryToMove(board, 0, 5);

        assertThat(board.getRacingCar().getCars().size()).isEqualTo(2);
        assertThat(board.getRacingCar().getCars().get(0).getLocation()).isEqualTo(2);

    }
    
}