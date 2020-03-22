package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private static final List<String> CAR_NAMES = Arrays.asList("Mark", "Jaehyun", "Johnny");
    private Cars cars;
    private RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

    @BeforeEach
    void setUp() {
        Car car = new Car("Mark", 5);
        Car car2 = new Car("Johnny", 2);
        Car car3 = new Car("Jaehyun", 1);
        cars = new Cars(Arrays.asList(car, car2, car3));

    }

    @Test
    void findWinnerTest() {
        //when
        List<Car> winners = cars.findWinner();

        //then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("Mark");
    }
}