package racing.domain.car.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.vo.Location;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LocationTest {
    @ValueSource(ints = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 100000
    })
    @ParameterizedTest
    public void ctorTest(int value) {
        new Location(value);
    }

    @ValueSource(ints = {
            -1, -10, -100
    })
    @ParameterizedTest
    public void ctorIllegalArgumentExceptionTest(int value) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Location(value)
        );
    }

    @CsvSource({
            "1,1,2",
            "3,5,8",
            "2,9,11",
    })
    @ParameterizedTest
    public void addTest(int locationValue, int addLocationValue, int resultLocationValue) {
        Location location = new Location(locationValue);
        Location addLocation = new Location(addLocationValue);
        Location resultLocation = new Location(resultLocationValue);

        assertThat(location.add(addLocation))
                .isEqualTo(resultLocation);
    }
}