package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.fixture.CarFixture;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() throws Exception {
        car = CarFixture.createCar();
    }

    @DisplayName("자동차가 전진 하는지 테스트")
    @Test
    void moveCar() {
        StateGenerator stateGenerator = () -> State.MOVE;
        Location expected = new Location(1);

        car.move(stateGenerator);

        assertThat(car.getLocation()).isEqualTo(expected);
    }

    @DisplayName("자동차가 정지해 있는지 테스트")
    @Test
    void stopCar() {
        StateGenerator stateGenerator = () -> State.STOP;
        Location expected = new Location();

        car.move(stateGenerator);

        assertThat(car.getLocation()).isEqualTo(expected);
    }

    @DisplayName("자동차의 이름이 맞는지 동등성 테스트")
    @Test
    void checkCarName() throws Exception {
        Name expected = new Name(CarFixture.ENTRY_CAR_NAME);

        assertThat(car.getName()).isEqualTo(expected);
    }

    @DisplayName("자동차의 위치가 같은지 동등성 테스트")
    @Test
    void checkCarLocation() {
        Location expected = new Location(Location.START_LOCATION);

        assertThat(car.getLocation()).isEqualTo(expected);
    }
}
