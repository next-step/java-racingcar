package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Position;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @DisplayName("Position이 음수가 나오는지 확인")
    @Test
    void positionValueTest() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
