package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static final String ENTRY_CAR_NAMES = "jae,han";

    @DisplayName("경주에 참가한 자동차들이 이동한지 확인")
    @Test
    void carsMoveTest() throws Exception {
        StateGenerator stateGenerator = () -> State.MOVE;
        int actual = 2;
        Location excepted = new Location(3);
        Names names = Names.from(ENTRY_CAR_NAMES);

        Cars cars = Cars.of(names, actual);
        cars.roundRacing(stateGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getLocation()).isEqualTo(excepted);
        }
    }

    @DisplayName("경주에 참가한 자동차들이 정지한지 확인")
    @Test
    void carsStopTest() throws Exception {
        StateGenerator stateGenerator = () -> State.STOP;
        int location = 2;
        Names names = Names.from(ENTRY_CAR_NAMES);

        Cars cars = Cars.of(names, location);
        cars.roundRacing(stateGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getLocation().getLocation()).isEqualTo(location);
        }
    }

    @DisplayName("경주에 참가한 자동차들이 전진 했을 때 최고기록의 위치를 테스트 ")
    @Test
    void carsFirstRecordTest() throws Exception {
        StateGenerator stateGenerator = () -> State.MOVE;
        int location = 2;
        Names names = Names.from(ENTRY_CAR_NAMES);
        Location excepted = new Location(3);

        Cars cars = Cars.of(names, location);
        cars.roundRacing(stateGenerator);

        assertThat(cars.inFormFirstRecord()).isEqualTo(excepted);
    }

    @DisplayName("경주에 참가한 자동차들의 우승자를 확인")
    @Test
    void carsWinnerTest() throws Exception {
        StateGenerator stateGenerator = () -> State.MOVE;
        int actual = 2;
        Location excepted = new Location(3);
        Names names = Names.from(ENTRY_CAR_NAMES);

        Cars cars = Cars.of(names, actual);
        cars.roundRacing(stateGenerator);

        Location firstRecord = cars.inFormFirstRecord();
        Names winner = cars.inFormWinners(firstRecord);

        assertThat(winner.printNames()).isEqualTo(ENTRY_CAR_NAMES);
    }
}
