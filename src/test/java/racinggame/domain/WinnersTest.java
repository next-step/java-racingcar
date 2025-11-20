package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnersTest {
    @Test
    void getWinnerNames() {
        Car pobi = new Car("pobi", 5);
        Car jason = new Car("jason", 5);
        List<Car> cars = List.of(pobi, jason);

        Winners winners = new Winners(cars);
        assertThat(winners.getWinnerNames()).contains("pobi", "jason");
        assertThat(winners.getCommaSeparatedWinnerNames()).isEqualTo("pobi, jason");
    }

    @Test
    void validate() {
        assertThatThrownBy(() -> new Winners(null))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Winners(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승자_구하기() {
        Car pobi = new Car("pobi", 5);
        Car jason = new Car("jason", 4);
        Car woni = new Car("woni", 3);
        List<Car> cars = List.of(pobi, jason, woni);

        Winners winners = Winners.findWinners(cars);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.contains(pobi)).isTrue();
    }
}
