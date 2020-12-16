package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveStrategyTest {

    @Test
    @DisplayName("주어진 이동 전략에 따라 전진")
    void testAlwaysMoveStrategy() {
        // given
        Cars cars = new Cars("pobi,crong,honux");
        // when
        cars.moveAll(() -> true);
        // then
        cars.iterateCar((name, dist) -> assertThat(dist).isEqualTo(1));
    }

    @Test
    @DisplayName("특정 값 이상일 경우 전진")
    void testMoveWhenMovable() {
        // given
        Cars cars = new Cars("pobi,crong,honux");
        // when
        cars.moveAll(new RandomMoveStrategy(9, 9));
        // then
        cars.iterateCar((name, dist) -> assertThat(dist).isEqualTo(1));
    }

    @Test
    @DisplayName("특정 값 이상이 아닐 경우 전진 안함")
    void testMoveWhenNotMovable() {
        // given
        Cars cars = new Cars("pobi,crong,honux");
        // when
        cars.moveAll(new RandomMoveStrategy(1, 1));
        // then
        cars.iterateCar((name, dist) -> assertThat(dist).isEqualTo(0));
    }
}
