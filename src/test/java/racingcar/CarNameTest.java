package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;
import racingcar.exception.CarNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    void createCarNameTest() {
        CarName carName = new CarName("jisu");
        assertThat(carName).isEqualTo(new CarName("jisu"));
    }

    @Test
    void validCarNameTest() {
        assertThatThrownBy(() -> {
            new CarName("jisuere");
        }).isInstanceOf(CarNameException.class);
    }
}
