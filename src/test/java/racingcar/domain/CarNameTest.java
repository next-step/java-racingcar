package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;
import racingcar.exception.CarNameInputException;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @Test
    void carNameTest_validate() {
        assertThat(new CarName("hello").getValue()).isEqualTo("hello");
        assertThatThrownBy(() -> new CarName("hello world")).isInstanceOf(CarNameInputException.class);
    }
}
