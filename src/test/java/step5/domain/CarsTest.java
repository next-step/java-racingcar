package step5.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 우승자_반환() {
        Car finn = new Car("finn" ,2);
        Car foo = new Car("foo", 1);
        Car var = new Car("var", 2);
        Cars cars = new Cars(List.of(finn,foo,var));

        List<Car> winners = cars.getWinners();
        assertThat(winners).containsExactlyInAnyOrder(finn, var);
    }
}
