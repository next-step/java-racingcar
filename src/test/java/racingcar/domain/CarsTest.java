package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 우승자_찾기() {
        Car ga = new Car("가");
        ga.move(4);
        ga.move(4);
        Car na = new Car("나");
        na.move(3);
        na.move(4);
        Cars cars = new Cars(Arrays.asList(ga, na));
        List<Car> winners = cars.findWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners).contains(ga);
    }


}
