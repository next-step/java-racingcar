package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("차 이름 길이가 5보다 큰 경우 예외 확인")
    void testTooLongCarName() {
        assertThatThrownBy(() -> {new Car("jackson");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name length shouldn't be longer than 5");
    }

    @Test
    @DisplayName("차 이름이 null 경우 예외 확인")
    void testNullName() {
        assertThatThrownBy(() -> {new Car(null);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name cannot be empty");
    }

    @Test
    @DisplayName("차 이름이 공백 경우 예외 확인")
    void testEmptyName() {
        assertThatThrownBy(() -> {new Car("");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name cannot be empty");
    }
}
