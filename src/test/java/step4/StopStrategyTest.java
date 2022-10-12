package step4;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class StopStrategyTest {

    @Test
    public void 항상_움직일_수_없다() {
        MovableStrategy stopStrategy = new StopStrategy();
        assertFalse(stopStrategy.isMovable());
    }
}
