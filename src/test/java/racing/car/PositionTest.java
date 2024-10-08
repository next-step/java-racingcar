package racing.car;

import org.junit.jupiter.api.Test;
import racing.domain.car.Car;
import racing.domain.car.Position;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void maxPosition(){
        Position position = new Position(4);
        assertThat(position.maxPosition(5)).isEqualTo(5);
    }

    @Test
    void isSame(){
        Position position = new Position(4);
        assertThat(position.isSame(4)).isTrue();
        assertThat(position.isSame(5)).isFalse();
    }

    @Test
    void inclease(){
        Position position = new Position(4);
        assertThat(position.increase()).isEqualTo(new Position(5));
    }

}
