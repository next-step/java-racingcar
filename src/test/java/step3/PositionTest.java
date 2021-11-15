package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    
    @Test
    @DisplayName("객체생성시 기본값은 0이다")
    public void defaultZero() {
        Position position = new Position();

        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("plus를 호출하면 +1이 된다")
    public void plusPosition() {
        Position position = new Position();
        position.plusPosition();

        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("position 생성시 position 객체를 인자로 넘기면 같은 값으로 생성된다")
    public void deepCopy() {
        Position position = new Position(2);

        assertThat(new Position(position)).isEqualTo(position);
    }

}