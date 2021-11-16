package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.fixture.CarsFixture;
import racinggame.domain.fixture.NamesFixture;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("경주에 참가한 자동차들이 이동한지 확인")
    @Test
    void carsMoveTest() throws Exception {
        StateGenerator stateGenerator = () -> State.MOVE;
        int actual = 2;
        Location excepted = new Location(3);

        Cars cars = CarsFixture.createCars(actual);
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

        Cars cars = CarsFixture.createCars(location);
        cars.roundRacing(stateGenerator);

        for (Car car : cars.getCars()) {
            assertThat(car.getLocation().getLocation()).isEqualTo(location);
        }
    }

    @DisplayName("경주에 참가한 자동차들의 우승자를 확인")
    @Test
    void carsWinnerTest() throws Exception {
        StateGenerator stateGenerator = () -> State.MOVE;
        int actual = 2;

        Cars cars = CarsFixture.createCars(actual);
        cars.roundRacing(stateGenerator);

        Names winner = cars.findWinners();

        assertThat(winner.printNames()).isEqualTo(NamesFixture.ENTRY_CAR_NAMES);
    }
}
