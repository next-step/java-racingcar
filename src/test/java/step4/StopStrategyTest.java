package step4;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StopStrategyTest {

    @Test
    public void 항상_움직일_수_없다() {
        MovableStrategy stopStrategy = new StopStrategy();
        assertFalse(stopStrategy.isMovable());
    }
}
