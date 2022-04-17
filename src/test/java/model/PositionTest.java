package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position position;

    @BeforeEach
    void beforeAll() {
        position = new Position();
    }

    @Test
    void 위치값이_정상적으로_하나씩_더해지는지_확인() {
        position.plus();
        assertThat(position.getPosition()).isEqualTo(1);

        position.plus();
        assertThat(position.getPosition()).isEqualTo(2);
    }

}
