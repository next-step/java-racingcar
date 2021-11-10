package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static final Integer ENTRY_CAR_COUNT = 2;
    private static final Integer LOCATION_ZERO = 0;
    private static final Integer LOCATION_ONE = 1;

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(ENTRY_CAR_COUNT);
    }

    @DisplayName("경주에 참가한 자동차들이 이동한지 확인")
    @Test
    void carsMoveTest() {
        StateGenerator stateGenerator = () -> State.MOVE;

        cars.roundRacing(stateGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getLocation().getLocation()).isEqualTo(LOCATION_ONE);
        }
    }

    @DisplayName("경주에 참가한 자동차들이 정지한지 확인")
    @Test
    void carsStopTest() {
        StateGenerator stateGenerator = () -> State.STOP;

        cars.roundRacing(stateGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getLocation().getLocation()).isEqualTo(LOCATION_ZERO);
        }
    }
}
