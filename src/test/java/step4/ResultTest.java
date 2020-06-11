package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.mock.MockFuel;
import step4.model.Car;
import step4.model.Cars;
import step4.model.Fuel;
import step4.model.Result;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    List<Car> list; Fuel fuel; Cars cars;

    @BeforeEach
    void setUp() {
        list = getCarList();
        cars = new Cars("peter,kassie,oak");
        fuel = new MockFuel();
    }

    @Test
    void create() {
        Result result = new Result(list);
        assertThat(result).isEqualTo(new Result(list));
    }

    @Test
    void getMaximum() {
        Result result = cars.move(fuel);
        int max = result.getMax();
        assertThat(max).isEqualTo(1);
    }

    @Test
    void getWinnerList() {
        Result result = cars.move(fuel);
        List<Car> winners = result.getWinners(1);
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    void getWinner() {
        Result result = cars.move(fuel);
        String winner = result.getWinner();
        assertThat(winner).isEqualTo("peter, kassie, oak");
    }

    private List<Car> getCarList() {
        return Arrays.asList(
                Car.of("peter"),
                Car.of("kassie"),
                Car.of("oak"));
    }
}
