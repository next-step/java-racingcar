package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentLocationTest {

    @Test
    void moveTest() {
        //given
        CurrentLocation currentLocation = new CurrentLocation();

        //when
        currentLocation.moveForward();

        //then
        assertThat(currentLocation.getLocationValue()).isEqualTo(2);
    }

}