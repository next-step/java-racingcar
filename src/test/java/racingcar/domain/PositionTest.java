package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    Position position;
    int DEFAULT_POSITION = 3;

    @BeforeEach
    void setUp() {
        position = new Position(DEFAULT_POSITION);
    }


    @Test
    void createPosition() {
        assertThat(position).isEqualTo(new Position(DEFAULT_POSITION));
    }

    @Test
    void validPosition() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void movePosition() {
        assertThat(position.move().isSame(DEFAULT_POSITION + 1)).isTrue();
    }

    @Test
    void checkPosition() {
        assertThat(position.isSame(DEFAULT_POSITION)).isTrue();
        assertThat(position.isSame(DEFAULT_POSITION + 1)).isFalse();
    }

    @Test
    void comparePosition(){
        assertThat(position.compareTo(new Position(DEFAULT_POSITION + 1))).isEqualTo(-1);
        assertThat(position.compareTo(new Position(DEFAULT_POSITION))).isEqualTo(0);
        assertThat(position.compareTo(new Position(DEFAULT_POSITION - 1))).isEqualTo(1);

    }
}
