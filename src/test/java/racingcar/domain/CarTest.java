package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    private static final int INITIAL_POSITION = 0;

    @BeforeEach
    private void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @DisplayName("랜덤숫자가 4이상 move")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void car_move_test(int input) {
        car.move(new RandomMoveStrategy(input));
        assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION + 1);
    }

    @ParameterizedTest
    @DisplayName("랜덤숫자가 4이하 스탑")
    @ValueSource(ints = {1, 2, 3})
    void car_not_move_test(int input) {
        car.move(new RandomMoveStrategy(input));
        assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION);
    }
}
