package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.policy.RandomMovingPolicy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;
    private final int MOVE_CONDITION = 4;
    private final int IMPOSSIBLE_MOVE_MIN_RANGE = 0;
    private final int IMPOSSIBLE_MOVE_MAX_RANGE = 4;
    private final int POSSIBLE_MOVE_MIN_RANGE = 4;
    private final int POSSIBLE_MOVE_MAX_RANGE = 10;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        carList.add(new Car());
        carList.add(new Car());
        cars = new Cars(carList);
    }

    @DisplayName("자동차들이 총 1번 이동을 성공한다.")
    @Test
    void move() {
        // when
        cars.move(new RandomMovingPolicy(POSSIBLE_MOVE_MIN_RANGE, POSSIBLE_MOVE_MAX_RANGE, MOVE_CONDITION));

        // then
        for (Car car : cars.getCars()) {
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @DisplayName("자동차들의 이동이 없음을 성공한다.")
    @Test
    void stop() {
        // when
        cars.move(new RandomMovingPolicy(IMPOSSIBLE_MOVE_MIN_RANGE, IMPOSSIBLE_MOVE_MAX_RANGE, MOVE_CONDITION));

        // then
        for (Car car : cars.getCars()) {
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }
}