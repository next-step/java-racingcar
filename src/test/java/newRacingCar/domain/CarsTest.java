package newRacingCar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;
    private Car pobi = new Car(new Name("pobi"), new Position(4));
    private Car min = new Car(new Name("min"), new Position(4));
    private Car ji = new Car(new Name("ji"), new Position(2));

    @Test
    void 우승자_찾기_테스트() {
        List<Car> carList = Arrays.asList(pobi, min, ji);
        cars = new Cars(carList);

        assertThat(cars.findWinners()).isEqualTo(Arrays.asList(pobi, min));
    }

    @Test
    void 가장_멀리간_차_찾기_테스트() {
        List<Car> carList = Arrays.asList(pobi, min, ji);
        cars = new Cars(carList);

        assertThat(cars.maxPositionCar()).isEqualTo(new Position(4));
    }
}
