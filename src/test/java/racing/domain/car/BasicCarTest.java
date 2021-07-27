package racing.domain.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.BasicFuel;

import static org.assertj.core.api.Assertions.*;

class BasicCarTest {
    private static Name anonymousName;

    @BeforeAll
    public static void setUp() {
        anonymousName = new Name("AAA");
    }

    @CsvSource({
            "0,100,0",
            "4,100,100",
            "9,100,100"
    })
    @DisplayName("Car Move 테스트 (BasicFuel 사용)")
    @ParameterizedTest
    public void moveTest(int fuelValue, int turnSize, int locationValue) {
        Location location = new Location(locationValue);
        BasicFuel fuel = new BasicFuel(fuelValue);

        Car car = new Car(anonymousName);
        for (int i = 0; i < turnSize; i++)
            car = car.move(fuel);

        assertThat(
                car.compareLocation(location)
        ).withFailMessage("자동차가 요청한대로 행동하지 않았습니다.")
                .isEqualTo(0);
    }

    @CsvSource({
            "-1,100",
            "0,100",
            "10,100",
    })
    @DisplayName("Car Move IllegalArgumentException 테스트")
    @ParameterizedTest
    public void moveIllegalArgumentExceptionTest(int fuelValue, int turnSize) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                moveTest(fuelValue, turnSize, -1)
        );
    }
}