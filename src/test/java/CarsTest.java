import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("단독 우승자가 있는 경우 해당 자동차만 반환한다")
    void getSingleWinner() {
        // given
        Cars cars = createCars("car1", "car2", "car3");
        cars.moveAll(new FixedMoveStrategy(new boolean[]{true, false, false}));

        // then
        assertThat(cars.findWinners()).hasSize(1);
        assertThat(cars.findWinners()).contains(createCarStatus("car1", 1));
    }

    @Test
    @DisplayName("공동 우승자가 있는 경우 모든 우승자를 반환한다")
    void getMultipleWinners() {
        // given
        Cars cars = createCars("car1", "car2", "car3");
        cars.moveAll(new FixedMoveStrategy(new boolean[]{true, true, false}));

        // then
        assertThat(cars.findWinners()).hasSize(2);
        assertThat(cars.findWinners()).contains(createCarStatus("car1", 1), createCarStatus("car2", 1));
    }

    private Cars createCars(String... names) {
        return Cars.fromNames(names);
    }

    private CarStatus createCarStatus(String name, int position) {
        return new CarStatus(name, position);
    }

    private static class FixedMoveStrategy implements MoveStrategy {

        private final boolean[] moves;
        private int index = 0;

        FixedMoveStrategy(boolean[] moves) {
            this.moves = moves;
        }

        @Override
        public boolean shouldMove() {
            if (index >= moves.length) {
                index = 0;
            }
            return moves[index++];
        }
    }
}
