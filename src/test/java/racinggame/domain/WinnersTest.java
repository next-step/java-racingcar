package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void 우승자_구하기() {
        Car pobi = new Car("pobi", 5);
        Car jason = new Car("jason", 4);
        Car woni = new Car("woni", 3);
        List<Car> cars = List.of(pobi, jason, woni);

        List<Car> winners = Winners.findWinners(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners).contains(pobi);
    }
}
