package racing.domain;

import com.racing.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    @DisplayName("Position 객체가 생성자를 통해 정상적으로 만들어지는지 여부")
    public void positionConstructorTest() {
        Position position = new Position(5);

        assertThat(new Position(5)).isEqualTo(position);
    }

    @Test
    @DisplayName("Position add 함수를 실행했을 때 정상적으로 1이 더해지는지 여부")
    public void positionAddFuncTest() {
        Position position = new Position(0);
        position.addPosition();
        position.addPosition();

        assertThat(position.getPosition()).isEqualTo(2);
    }
}
