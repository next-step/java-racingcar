package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 우승자_찾기() {
        Car ga = new Car("가", 4);
        Car na = new Car("나", 3);
        Cars cars = new Cars(Arrays.asList(ga, na));
        Winners winners = cars.findWinners();
        assertThat(winners.getWinners()).hasSize(1);
        assertThat(winners.getWinners()).contains(ga);
    }
}
