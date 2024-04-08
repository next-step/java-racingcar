package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarLocationTest {

    @Test
    void 위치_증가() throws Exception {
        CarLocation carLocation = new CarLocation();
        carLocation.increase();
        assertThat(carLocation).isEqualTo(new CarLocation(1));
    }
}
