package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.MockCarMoverTest.mockMover;
import static racingcar.model.RandomCarMover.MOVING_CONDITION;

class CarsTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("개수만큼 자동차를 생성한다")
    void carGenerator() {
        int count = 3;
        Cars generate = Cars.generate(count);
        assertThat(generate).isNotNull();
        assertThat(generate.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차가 전진합니다")
    void moveCarSuccess() {
        assertThat(isMoveCar(MOVING_CONDITION)).isTrue();
    }

    @Test
    @DisplayName("자동차 전진하는데 실패")
    void moveCarFail() {
        assertThat(isMoveCar(MOVING_CONDITION-1)).isFalse();
    }

    private boolean isMoveCar(int state) {
        Car car = new Car();
        Cars cars = new Cars(Arrays.asList(car));
        MockCarMover mover = mockMover(state);
        return cars.move(mover, car);
    }
}