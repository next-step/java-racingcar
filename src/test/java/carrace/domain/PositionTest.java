package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class PositionTest {

    @Test
    @DisplayName("음수 입력 Exception")
    void negative() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Position position = new Position(-1);
                }).withMessage("음수 값의 Position 은 존재할 수 없습니다.");
    }
}
