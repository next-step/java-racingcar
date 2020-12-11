package carrace.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void getPosition() {
        Position position = new Position(5);
        assertThat(position.getPosition()).isEqualTo(5);
    }

    @Test
    void forward() {
        Position position = new Position(5);
        position.forward();
        assertThat(position.getPosition()).isEqualTo(6);
    }

    @Test
    void getResult() {
        Position position = new Position(5);
        assertThat(position.getResult()).isEqualTo("-----");
    }
}