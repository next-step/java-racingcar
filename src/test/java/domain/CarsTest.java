package domain;

import org.junit.jupiter.api.Test;
import strategy.MovableStrategy;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void createCarsTest() {
        String names = "a,b,c";
        Cars cars = new Cars(names);
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars()).contains(new Car("a"), new Car("b"), new Car("c"));
    }

    @Test
    public void moveAllTest() {
        String names = "a,b,c";
        Cars cars = new Cars(names);
        MovableStrategy trueMovableStrategy = () -> true;

        cars.moveAll(trueMovableStrategy);

        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars()).contains(new Car("a", 1),
                new Car("b", 1),
                new Car("c", 1));
    }

    @Test
    public void getWinnersTest() {
        Cars cars = new Cars(Arrays.asList(new Car("kks", 0),
                new Car("kjm", 0),
                new Car("bjs", 4)));

        assertThat(cars.getWinners()).hasSize(1);
        assertThat(cars.getWinners()).contains("bjs");
    }

    @Test
    public void canGetGreaterThanTwoWinnersTest() {
        Cars cars = new Cars(Arrays.asList(new Car("kks", 0),
                new Car("kjm", 4),
                new Car("bjs", 4)));

        assertThat(cars.getWinners()).hasSize(2);
        assertThat(cars.getWinners()).contains("bjs", "kjm");
    }

}
