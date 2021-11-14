package racinggame.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.OverNameLengthException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("자동차 이름에 입력된 이름길이가 5자를 초과할 경우 예외발생")
    @Test
    void validateLength() {
        String input = "hystrix";

        assertThatThrownBy(() -> Name.of(input))
                .isInstanceOf(OverNameLengthException.class);
    }
}
