package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void carRun() {
        car.move(Car.RUNNING_CONDITION);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void noMove() {
        car.move(Car.RUNNING_CONDITION - 1);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void moveWhenStatusNegativeNumberThenFail(int wrongStatus) {
        assertThatIllegalArgumentException().isThrownBy(() -> car.move(wrongStatus));
    }

}