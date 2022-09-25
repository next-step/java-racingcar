package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void create_and_move() {
        List<Position> move = new Cars(5).move(() -> true);

        assertThat(move).hasSize(5);
        assertThat(move).containsOnly(new Position(1));
    }

}
