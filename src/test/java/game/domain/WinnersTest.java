package game.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static game.domain.Winners.findWinners;
import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    void 우승자_구하기() {
        Cars cars = new Cars(List.of(new Car(3, "pobi"), new Car(2, "jason")));

        Cars winners = findWinners(cars);

        assertThat(winners.contains(new Car(3, "pobi"))).isTrue();
    }
}
