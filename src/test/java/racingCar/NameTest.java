package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domains.Name;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void lengthIsLargerThanFive() {
        assertThatThrownBy(() -> {
            new Name("jinsol");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
