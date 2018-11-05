package racinggame.model;

import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {

    private static List<Car> cars = new ArrayList<>();

    @Before
    public void setUp() {
        String[] inputCars = {"owner","chris","mary", "john"};
        int[] inputPosition = {1, 3, 2 ,3};

        for(int i = 0; i < inputCars.length; i++) {
            Car car = new Car(inputCars[i], inputPosition[i]);
            cars.add(car);
        }
    }

    @Test
    public void 레이싱_경기_우승자_구하기() {

        RacingGameResult racingGameResult = new RacingGameResult(cars);

        List<String> winners = racingGameResult.getWinner();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains("chris", "john");
    }

}