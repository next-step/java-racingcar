package racingCar.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @DisplayName("이름의 길이가 5자를 초과한 경우 IllegalArgumentException 발생")
    @Test
    void lengthIsLargerThanFive() {
        assertThatThrownBy(() -> {
            new Name("jinsol");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
