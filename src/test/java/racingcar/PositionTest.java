package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("move()를 호출하면 position이 1 증가한다.")
    void move() {
        //arrange
        Position position = new Position();

        //act
        position.move();

        //assert
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
