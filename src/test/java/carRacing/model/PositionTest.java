package carRacing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    private Position position;

    @BeforeEach
    void initializePositionTest() {
        position = new Position(3);
    }

    @Test
    @DisplayName("move position test")
    void moveTest() {
        assertThat(position.move()).isEqualTo(new Position(4));
    }

    @Test
    @DisplayName("create position test")
    void createTest() {
        assertThat(position).isEqualTo(new Position(3));

    }

    @Test
    @DisplayName("validate position test")
    void validTest() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효한 양의 정수를 입력하세요");
    }
}