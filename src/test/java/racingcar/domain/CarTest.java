package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;
import racingcar.condition.MoveCondition;
import racingcar.condition.RandomMoveCondition;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private MoveCondition moveCondition;

    @BeforeEach
    public void setUp() {
        this.moveCondition = new RandomMoveCondition();
    }

    @Test
    void equals_max_position() {
        Car car = new Car("유민", 3, moveCondition);
        assertThat(car.hasMaxPosition(3)).isTrue();
    }

    @Test
    void get_maximum() {
        Car car = new Car("유민", 3, moveCondition);
        assertThat(car.comparePosition(4)).isEqualTo(4);
        assertThat(car.comparePosition(2)).isEqualTo(3);
    }
}
