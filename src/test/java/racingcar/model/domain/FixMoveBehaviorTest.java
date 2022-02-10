package racingcar.model.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FixMoveBehaviorTest {

    @DisplayName("주사위가_4이상인_경우_무조건_이동")
    @Test
    void moveStepCar() {
        FixMoveBehavior fixMoveBehavior = new FixMoveBehavior(true);
        assertTrue(fixMoveBehavior.moveBehavior());
    }
}
