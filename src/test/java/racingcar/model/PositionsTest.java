package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PositionsTest {

        @Test
        void 위치_최댓값_찾기() {
                Position position1 = new Position();
                Position position2 = new Position();
                Position position3 = new Position();
                Position position4 = new Position();
                position1.addOnePosition();
                position2.addOnePosition();
                position2.addOnePosition();
                Positions positions = new Positions(List.of(position1, position2, position3, position4));
                assertThat(positions.getMaxPosition().getValue()).isEqualTo(3);
        }
}
