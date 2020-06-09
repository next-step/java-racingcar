package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    List<Car> list; Fuel fuel; Cars cars;

    @BeforeEach
    void setUp() {
        list = getCarList();
        cars = new Cars("peter,kassie,oak");
        fuel = new Fuel() {
            @Override
            public boolean isValid() {
                return true;
            }
        };
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
    void getWinners() {
        Result result = cars.move(fuel);
        List<Car> winners = result.getWinners(1);
        assertThat(winners.size()).isEqualTo(3);
    }

    private List<Car> getCarList() {
        return Arrays.asList(
                Car.of("peter"),
                Car.of("kassie"),
                Car.of("oak"));
    }
}
