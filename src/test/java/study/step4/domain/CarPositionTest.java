package study.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarPositionTest {

    @DisplayName("포시션은 음수가 될 수 없다")
    @Test
    void postion() {
        assertThatThrownBy(() -> {
            CarPosition position = new CarPosition(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("car postion 은 음수가될수 없다");
    }

}