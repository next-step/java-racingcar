package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("차 이름 길이가 5보다 큰 경우 예외 확인")
    void testTooLongCarName() {
        assertThatThrownBy(() -> {
            new CarName("jackson");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name length shouldn't be longer than 5");
    }

    @Test
    @DisplayName("차 이름이 null 경우 예외 확인")
    void testNullName() {
        assertThatThrownBy(() -> {
            new CarName(null);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name cannot be empty");
    }

    @Test
    @DisplayName("차 이름이 공백 경우 예외 확인")
    void testEmptyName() {
        assertThatThrownBy(() -> {
            new CarName("");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name cannot be empty");
    }
}
