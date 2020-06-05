package autoracing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest {
    private final int NEVER_PLAYED_ROUND_WHEN_CAR_RACED_ONLY_ONCE = 2;

    private RacingRule rule;

    @BeforeAll
    public void init() {
        this.rule = new RandomRacingRule(10, 4);
    }

    @Test
    public void newCar() {
        Car car = new Car(rule);
        assertThat(car.getLocation(0)).isEqualTo(Location.STARTING_LINE);
        assertThatIllegalArgumentExceptionIsThrownByCarGetLocation(car, 1);
    }

    @ParameterizedTest
    @CsvSource({"true,1", "false,0"})
    public void shouldRecordWhenRacing(boolean driveOrNot, int expectedDistance) {
        Car car = new Car(() -> driveOrNot);
        car.race();
        assertThat(getFirstRoundLocation(car)).isEqualToComparingFieldByField(new Location(expectedDistance, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 8, 10, 987})
    public void hasHistorySameAmountAsRounds(int rounds) {
        Car car = new Car(rule);
        for (int i = 0; i < rounds; i++) {
            car.race();
        }
        int expectedNeverPlayedRound = rounds + 1;
        assertThatIllegalArgumentExceptionIsThrownByCarGetLocation(car, expectedNeverPlayedRound);
    }

    private Location getFirstRoundLocation(Car car) {
        assertThatIllegalArgumentExceptionIsThrownByCarGetLocation(car, NEVER_PLAYED_ROUND_WHEN_CAR_RACED_ONLY_ONCE);
        return car.getLocation(1);
    }

    private void assertThatIllegalArgumentExceptionIsThrownByCarGetLocation(Car car, int round) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            car.getLocation(round);
        }).withMessage(String.format("The car has never played that round '%d'.", round));
    }
}
