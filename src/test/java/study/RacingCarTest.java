package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;
import racingcar.Name;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Test
    @ParameterizedTest
    @ValueSource(strings = {"apple"})
    void name(final String name) {
        final Name carName = Name.of(name);
        final Car car = Car.of(carName, 0);
        assertThat(car.getName()).isEqualTo("apple");
    }
}
