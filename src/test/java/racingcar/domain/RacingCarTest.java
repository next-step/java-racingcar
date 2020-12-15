package racingcar.domain;

import org.junit.jupiter.api.Test;

import racingcar.service.Racing;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class RacingCarTest {

    @Test
    void racingCarDomainTest(){
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        List<Car> list= new ArrayList<>(List.of(car1, car2));
        RacingCar cars = new RacingCar(list);

        Scoreboard board = new Scoreboard(cars);

        Scoreboard board2 = new Scoreboard(cars);

        Racing racing = new Racing();

        racing.tryToMove(board, 0, 5);

        assertThat(cars.getCars().get(0)).isEqualTo(board2.getRacingCar().getCars().get(0));
    }

    @Test
    void getWinnerListTest(){
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");

        RacingCar racingCar = new RacingCar(List.of(car1, car2));

        racingCar.getCars().get(0).moveLocation();

        List<String> winner = racingCar.getWinnerList(2);

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0)).isEqualTo("test1");
    }
    
}