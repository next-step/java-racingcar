package racing.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static Name ANONYMOUS;

    @BeforeAll
    public static void setUp() {
        ANONYMOUS = new Name("ANONYMOUS");
    }

    @CsvSource({
            "0,0",
            "1,0",
            "2,0",
            "3,0",
            "4,1",
            "5,1",
            "6,1",
            "7,1",
            "8,1",
            "9,1"
    })
    @DisplayName("Move 테스트")
    @ParameterizedTest
    public void moveTest(int fuelValue, int locationValue) {
        Location location = new Location(locationValue);
        Fuel fuel = new Fuel(fuelValue);

        Car car = new Car(ANONYMOUS);
        car.move(fuel);

        assertThat(
                car.location()
        ).withFailMessage("자동차가 요청한대로 행동하지 않았습니다.")
                .isEqualTo(location);
    }
}