package pobiRacingCar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void findWinner() {
        Car pobi = new Car("pobi", 7);
        Car crong = new Car("crong", 6);
        //List<Car> cars = Arrays.asList(pobi, crong);
        Cars cars = new Cars(Arrays.asList(pobi, crong));

        Winners winners = cars.findWinners2();
        assertThat(winners.getWinners()).hasSize(1);
        assertThat(winners.getWinners()).containsExactly(pobi); //not Optimal, but now Winners Obj
    }

    @Test
    void findWinners() {
        Car pobi = new Car("pobi", 4);
        Car crong = new Car("crong", 3);
        Car honux = new Car("honux", 4);
        Cars cars = new Cars(Arrays.asList(pobi, crong, honux));

        Winners winners = cars.findWinners2();
        assertThat(winners.getWinners()).hasSize(2);
        assertThat(winners.getWinners()).containsExactly(pobi,honux);

    }
}
