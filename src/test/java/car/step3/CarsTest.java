package car.step3;

import car.step3.domain.Car;
import car.step3.domain.Cars;
import car.step3.domain.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CarsTest {

    @Test
    void findWinners() {
        List<Car> original = Arrays.asList(
                new Car("lim", new Position(3)),
                new Car("kim", new Position(3)),
                new Car("lee", new Position(2)));
        Cars cars = new Cars(original);
        List<Car> winners = cars.findWinners();
        Assertions.assertThat(winners).containsExactly(
                new Car("lim", new Position(3)),
                new Car("kim", new Position(3)));
    }
}
