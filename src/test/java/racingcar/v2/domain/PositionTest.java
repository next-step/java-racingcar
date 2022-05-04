package racingcar.v2.domain;


import org.junit.jupiter.api.Test;
import racingcar.v2.domain.car.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {


    @Test
    void invalidTest() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createTest() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position("1"));
    }

}