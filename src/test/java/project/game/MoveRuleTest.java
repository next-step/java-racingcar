package project.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveRuleTest {

    private MoveRule mAlwaysCanMoveRule;
    private MoveRule mAlwaysCannotMoveRule;

    @BeforeEach
    void setUp() {
        RandomNumberProvider alwaysReturnThreeNumberProvider = () -> 3;
        RandomNumberProvider alwaysReturnFourNumberProvider = () -> 4;

        mAlwaysCanMoveRule = new RandomlyMoveRule(alwaysReturnFourNumberProvider);
        mAlwaysCannotMoveRule = new RandomlyMoveRule(alwaysReturnThreeNumberProvider);
    }

    // instance 는 @ParameterizedTest 를 할 수 없는 것일까?
    @Test
    void testRandomlyMoveRule() {
        assertThat(mAlwaysCanMoveRule.canMove()).isTrue();
        assertThat(mAlwaysCannotMoveRule.canMove()).isFalse();
    }
}
