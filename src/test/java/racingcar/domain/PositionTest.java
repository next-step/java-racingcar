package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.raceStrategy.DoOneForward;
import racingcar.strategy.condition.RaceCondition;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @DisplayName("위치 OneForward조건 맞으면 1 증가")
    @Test
    void canIncrease() {
        Position pos1 = new Position(1);
        RaceCondition alwaysOneForward = () -> true;
        pos1.increase(alwaysOneForward, new DoOneForward());

        int expected = 2;

        assertThat(pos1.getPosition()).isEqualTo(expected);
    }

    @DisplayName("위치 OneForward조건 안 맞으면 그대로")
    @Test
    void canNotIncrease() {
        Position pos2 = new Position(3);
        RaceCondition alwaysZeroForward = () -> false;
        pos2.increase(alwaysZeroForward, new DoOneForward());

        int expected = 3;

        assertThat(pos2.getPosition()).isEqualTo(expected);
    }

}
