package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.Constants.*;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.RaceCondition;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    public void assertCarInitPositionIsZero() {

        assertThat(new Car(new Position(0)).getPosition()).isEqualTo(INIT_POSITION);

    }
    /**
     * Mocking Test (random 추상화) : PositionTest으로 이관
     */

}
