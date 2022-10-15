package step4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoveStrategyTest {

    @Test
    public void 항상_움직일_수_있다() {
        MovableStrategy moveStrategy = new MoveStrategy();
        assertTrue(moveStrategy.isMovable());
    }
}
