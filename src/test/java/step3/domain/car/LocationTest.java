package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LocationTest {

    private static final int LOCATION = 0;
    private static final int INTERVAL = 2;

    @Test
    void createLocation_nullInput_thrownException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Location.placeOn(null))
                .withMessage("location is required");
    }


    @ParameterizedTest(name = "[{index}] interval: {0}")
    @NullSource
    @CsvSource(value = {"-1"})
    void createLocation_NotPositiveInterval_thrownException(Integer interval) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Location.placeOn(LOCATION, interval))
                .withMessage("interval is not Positive");
    }

    @DisplayName("전진하면 거리가 interval 만큼 증가한다.")
    @Test
    void goForwardTest() {
        //given
        Location location = Location.placeOn(LOCATION, INTERVAL);

        //when
        location.goForward();

        //then
        assertThat(location).isEqualTo(Location.placeOn(LOCATION + INTERVAL));
    }

    @DisplayName("default interval은 1이다.")
    @Test
    void goForwardTest1() {
        //given
        Location location = Location.placeOn(LOCATION);

        //when
        location.goForward();

        //then
        assertThat(location).isEqualTo(Location.placeOn(LOCATION + 1));
    }

}
