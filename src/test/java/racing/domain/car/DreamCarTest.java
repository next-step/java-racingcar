package racing.domain.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;
import racing.domain.fuel.RandomFuel;

import static org.assertj.core.api.Assertions.assertThat;

public class DreamCarTest {
    private static Name ANONYMOUS;

    @BeforeAll
    public static void setUp() {
        ANONYMOUS = new Name("AAA");
    }

    @CsvSource({
            "100,100",
            "1000,1000",
            "10000,10000"
    })
    @DisplayName("Move 테스트")
    @ParameterizedTest
    public void moveTest(int turnSize, int locationValue) {
        Location location = new Location(locationValue);
        Fuel fuel = RandomFuel.getInstance();

        Car car = new DreamCar(ANONYMOUS);
        for (int i = 0; i < turnSize; i++)
            car.move(fuel);

        assertThat(
                car.checkLocation(location)
        ).withFailMessage("자동차가 요청한대로 행동하지 않았습니다.")
                .isTrue();
    }
}
