package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void 우승자_찾기() {
        Car pobi = new Car("pobi", 4);
        Car jason = new Car("jason", 3);
        Car woni = new Car("woni", 4);
        List<Car> cars = Arrays.asList(pobi, jason, woni);
        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners).hasSize(2);
        assertThat(winners).contains(pobi, woni);
    }
}
