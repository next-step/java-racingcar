package step5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    @Test
    void getWinners() {
        Car kim = new Car("kim", 0, new RandomMoveStrategy());
        Car lee = new Car("lee", 2, new RandomMoveStrategy());
        Car park = new Car("park", 2, new RandomMoveStrategy());
        List<Car> winners = Winners.getWinners(Arrays.asList(kim, lee, park));
        assertAll(
            () -> assertEquals(2, winners.size()),
            () -> assertThat(winners.get(0)).isEqualTo(new Car("lee", 2, new RandomMoveStrategy())),
            () -> assertThat(winners.get(1)).isEqualTo(new Car("park", 2, new RandomMoveStrategy()))
        );
    }

}
