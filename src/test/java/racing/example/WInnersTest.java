package racing.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WInnersTest {

    @Test
    void getWinners() {
        List<Car> cars = new ArrayList<>();
        Car ocean = new Car("ocean", 4);
        cars.add(ocean);
        cars.add(new Car("river", 0));
        cars.add(new Car("water", 0));

        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners).contains(ocean);
    }
}
