package step5;

import org.junit.jupiter.api.Test;
import step5.domain.Car;
import step5.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void winner() {
        Car yu = new Car("yu", 3);
        Car yeo = new Car("yeo", 4);
        Car jin = new Car("jin", 1);
        List<Car> carList = List.of(yu, yeo, jin);
        Cars cars = new Cars(carList);
        List<Integer> randomNums = List.of(4,2 , 7);

        cars.move(randomNums);
        List<Car> winners = cars.winners();

        assertThat(winners).hasSize(2);
        assertThat(winners).contains(yu);
    }
}
