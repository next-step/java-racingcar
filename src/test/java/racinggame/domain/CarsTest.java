package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static final Integer ENTRY_CAR_COUNT = 2;

    @DisplayName("경주에 참가한 자동차들이 이동한지 확인")
    @Test
    void carsMoveTest() {
        StateGenerator stateGenerator = () -> State.MOVE;
        int actual = 2;
        int excepted = 3;
        Cars cars = Cars.of(ENTRY_CAR_COUNT, actual);
        cars.roundRacing(stateGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getLocation().getLocation()).isEqualTo(excepted);
        }
    }

    @DisplayName("경주에 참가한 자동차들이 정지한지 확인")
    @Test
    void carsStopTest() {
        StateGenerator stateGenerator = () -> State.STOP;
        int location = 2;
        Cars cars = Cars.of(ENTRY_CAR_COUNT, location);
        cars.roundRacing(stateGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getLocation().getLocation()).isEqualTo(location);
        }
    }
}
