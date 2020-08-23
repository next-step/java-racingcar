package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.RaceCondition;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @DisplayName("위치 OneForward조건 맞으면 1 증가")
    @Test
    void canIncrease() {
        Position pos1 = new Position(3);
        RaceCondition alwaysOneForward = () -> true;
        pos1.increase(alwaysOneForward, new DoOneForward());
        int actual = pos1.getPosition();
        assertThat(actual).isEqualTo(4);
    }

}
