import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("자동차 목록이 비어있으면 예외가 발생한다")
    void emptyCarListThrowsError() {
        assertThatThrownBy(() -> Cars.fromNames(new String[0]))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 목록이 비어있습니다.");
    }

    @Test
    @DisplayName("자동차 목록이 null이면 예외가 발생한다")
    void nullCarListThrowsError() {
        assertThatThrownBy(() -> Cars.fromNames(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 목록이 비어있습니다.");
    }

    @Test
    @DisplayName("모든 자동차의 상태를 반환한다")
    void getAllCarStatuses() {
        // given
        Cars cars = createCars("car1", "car2", "car3");
        cars.moveAll(new FixedMoveStrategy(new boolean[]{true, false, true}));

        // when
        List<CarStatus> statuses = cars.getCarStatuses();

        // then
        assertThat(statuses).hasSize(3);
        assertThat(statuses).contains(
            createCarStatus("car1", 1),
            createCarStatus("car2", 0),
            createCarStatus("car3", 1)
        );
    }

    @Test
    @DisplayName("모든 자동차가 움직인다")
    void moveAllCars() {
        // given
        Cars cars = createCars("car1", "car2", "car3");
        FixedMoveStrategy strategy = new FixedMoveStrategy(new boolean[]{true, true, true});

        // when
        cars.moveAll(strategy);

        // then
        List<CarStatus> statuses = cars.getCarStatuses();
        assertThat(statuses).allMatch(status -> status.getPosition() == 1);
    }

    @Test
    @DisplayName("최대 위치를 찾는다")
    void findMaxPosition() {
        // given
        Cars cars = createCars("car1", "car2", "car3");
        cars.moveAll(new FixedMoveStrategy(new boolean[]{true, false, true}));
        cars.moveAll(new FixedMoveStrategy(new boolean[]{true, false, false}));

        // when
        List<CarStatus> winners = cars.findWinners();

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners).contains(createCarStatus("car1", 2));
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
