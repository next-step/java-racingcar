package domain;

import org.junit.jupiter.api.Test;
import strategy.MovableStrategy;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    public void moveAllTest() {
        Cars cars = new Cars(Arrays.asList(new Car("a"), new Car("b"), new Car("c")));
        MovableStrategy trueMovableStrategy = () -> true;

        cars.moveAll(trueMovableStrategy);

        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars()).contains(new Car("a", new Location(1)),
                new Car("b", new Location(1)),
                new Car("c", new Location(1)));
    }

    @Test
    public void getWinnersTest() {
        Cars cars = new Cars(Arrays.asList(new Car("kks", new Location()),
                new Car("kjm", new Location()),
                new Car("bjs", new Location(4))));

        assertThat(cars.getWinners()).hasSize(1);
        assertThat(cars.getWinners()).contains("bjs");
    }

    @Test
    public void canGetGreaterThanTwoWinnersTest() {
        Cars cars = new Cars(Arrays.asList(new Car("kks", new Location(0)),
                new Car("kjm", new Location(4)),
                new Car("bjs", new Location(4))));

        assertThat(cars.getWinners()).hasSize(2);
        assertThat(cars.getWinners()).contains("bjs", "kjm");
    }

}
