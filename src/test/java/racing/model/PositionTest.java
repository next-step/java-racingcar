package racing.model;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void create() {
        assertThat(new Position()).isEqualTo(new Position());
    }

    @Test
    void move() {
        Position position1 = new Position().moveOnSatisfiedCondition(4);
        assertThat(position1.getValue()).isEqualTo(0);

        Position position2 = new Position().moveOnSatisfiedCondition(5);
        assertThat(position2.getValue()).isEqualTo(1);
    }

    @Test
    void topPositionCheck() {
        List<Position> positionList = new LinkedList<>();
        Position position1 = new Position(1);
        positionList.add(position1);
        Position position2 = new Position(2);
        positionList.add(position2);
        Position position3 = new Position(3);
        positionList.add(position3);

        Position top = new Position(4);
        assertThat(top.isTopPosition(positionList)).isTrue();
        Position equal = new Position(3);
        assertThat(equal.isTopPosition(positionList)).isTrue();
        Position less = new Position(2);
        assertThat(less.isTopPosition(positionList)).isFalse();
    }
}