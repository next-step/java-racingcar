package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void createTest() {
        Position position = new Position();

        assertThat(position.equals(new Position())).isTrue();
    }

}