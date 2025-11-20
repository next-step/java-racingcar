package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void create() {
        Car pobi = new Car("pobi");
        Car jason = new Car("jason");
        Cars cars = new Cars(List.of(pobi, jason));
        assertThat(cars).isEqualTo(new Cars("pobi,jason"));
    }

    @Test
    void 우승자_구하기() {
        Car pobi = new Car("pobi", 5);
        Car jason = new Car("jason", 4);
        Car woni = new Car("woni", 3);
        Cars cars = new Cars(List.of(pobi, jason, woni));

        Winners winners = cars.findWinners();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.contains(pobi)).isTrue();
    }
}
