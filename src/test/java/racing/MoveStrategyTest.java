package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveStrategyTest {

    @Test
    @DisplayName("주어진 이동 전략에 따라 이동하는지?")
    void testAlwaysMoveStrategy() {
        // given
        Cars cars = new Cars(3, () -> true);
        // when
        cars.moveAll();
        // then
        cars.iterateCar(distance -> assertThat(distance).isEqualTo(1));
    }
}
