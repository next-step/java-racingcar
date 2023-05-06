package racing.vehicle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @ParameterizedTest(name = "Creating carName with valid name - {0}")
    @CsvSource(value = {"a", "aa", "aaa", "aaaa", "aaaaa"})
    public void validName(String name) {
        CarName car = new CarName(name);
        assertThat(car.toString()).isEqualTo(name);
    }

    @ParameterizedTest(name = "Creating carName with invalid name - {0}")
    @CsvSource(value = {"aaaaaa"})
    public void invalidName(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "Creating carName with null or empty name - {0}")
    @NullAndEmptySource
    public void nullOrEmptyName(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
