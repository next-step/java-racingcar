package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racing.domain.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinnersTest {

    @Nested
    @DisplayName("Cars가 주어지면 Position이 가장 큰 Winners를 반환")
    class FromTest {
        private final MoveStrategy alwaysMoveStrategy = () -> true;
        private final Car carA = Car.from("testA");
        private final Car carB = Car.from("testB");

        @Test
        @DisplayName("우승자가 한 명인 경우 우승자 목록 조회")
        void from_winner_is_only() {
            carA.play(alwaysMoveStrategy);
            assertThat(Winners.from(getCars(carA, carB))).containsExactly(carA);
        }

        @Test
        @DisplayName("우승자가 여러 명인 경우 우승자 목록 조회")
        void from_winner_is_not_only() {
            // given
            carA.play(alwaysMoveStrategy);
            carB.play(alwaysMoveStrategy);

            // then
            assertThat(Winners.from(getCars(carA, carB))).containsExactly(carA, carB);
        }

        private Cars getCars(Car... cars) {
            return Cars.from(List.of(cars));
        }
    }
}