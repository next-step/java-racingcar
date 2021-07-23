package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @CsvSource({
            "FULL,1",
            "MIN,1",
            "EMPTY,0"
    })
    @DisplayName("Move 테스트")
    @ParameterizedTest
    public void moveTest(String fuelName, int locationValue) {
        Location location = new Location(locationValue);
        Fuel fuel = Fuel.valueOf(fuelName);

        Car car = new Car();
        car.move(fuel);

        assertThat(
                car.getLocation()
        ).withFailMessage("자동차가 요청한대로 행동하지 않았습니다.")
                .isEqualTo(location);
    }
}