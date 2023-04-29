package carracing;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * 1. 위치는 음수값을 가질 수 없다.
 * 2. increase()를 호출하면 위치값을 1 증가시킬 수 있다.
 */
public class PositionTest {
    @Test
    void increase(){
        Position position = new Position(3);
        assertThat(position.increase()).isEqualTo(new Position(4));
    }

    @Test
    void create(){
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> {
            new Position(-3);
        }).hasMessage("position은 음수를 가질 수 없습니다.");
    }
}
