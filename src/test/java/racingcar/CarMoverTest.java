package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarMoverTest {

    @DisplayName("자동차를 이동시키면 자동차 개수만큼의 위치 정보를 담은 목록을 리턴한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    void move(int carCount) {
        List<Car> cars = getCars(carCount);
        CarMover mover = new CarMover(new RandomMoveStrategy());
        int[] positions = mover.move(cars);

        assertThat(positions.length).isEqualTo(carCount);
    }

    @DisplayName("자동차를 이동시키면 자동차의 위치는 이동 전과 같거나 크다")
    @Test
    void move_Then_positionIsEqualOrGreaterThanBeforePosition() {
        List<Car> cars = getCars(5);
        CarMover mover = new CarMover(new RandomMoveStrategy());
        int[] positions = mover.move(cars);

        for (int position : positions) {
            assertThat(position >= 0).isTrue();
        }
    }

    private List<Car> getCars(int count) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
