package racing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarMoveStrategyImplTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void canMove(int random) {
        CarMoveStrategy carMoveStrategy = new CarMoveStrategyImpl(bound -> random);
        assertThat(carMoveStrategy.isMovable()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void canNotMove(int random) {
        CarMoveStrategy carMoveStrategy = new CarMoveStrategyImpl(bound -> random);
        assertThat(carMoveStrategy.isMovable()).isFalse();
    }
}