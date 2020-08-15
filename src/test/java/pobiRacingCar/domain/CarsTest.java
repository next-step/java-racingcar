package pobiRacingCar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void findWinner() {
        Car pobi = new Car("pobi");
        pobi.move(4);
        pobi.move(3);
        Car crong = new Car("crong");
        crong.move(3);
        crong.move(3);
        //List<Car> cars = Arrays.asList(pobi, crong);
        Cars cars = new Cars(Arrays.asList(pobi, crong));

        Winners winners = cars.findWinners2();
        assertThat(winners.getWinners()).hasSize(1);
        assertThat(winners.getWinners()).containsExactly(pobi); //not Optimal, but now Winners Obj

    }
}
