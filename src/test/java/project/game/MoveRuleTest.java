package project.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
    @ParameterizedTest
    @MethodSource("createAlwaysCanMoveRules")
    void alwaysCanMoveRuleTest(MoveRule word) {
        assertThat(word.canMove()).isTrue();
    }

    private static Stream<MoveRule> createAlwaysCanMoveRules() {
        return Stream.of(
                new RandomlyMoveRule(() -> 8),
                new RandomlyMoveRule(() -> 7),
                new RandomlyMoveRule(() -> 6),
                new RandomlyMoveRule(() -> 5),
                new RandomlyMoveRule(() -> 4));
    }

    @ParameterizedTest
    @MethodSource("createAlwaysCannotMoveRules")
    void alwaysCannotMoveRuleTest(MoveRule word) {
        assertThat(word.canMove()).isFalse();
    }

    private static Stream<MoveRule> createAlwaysCannotMoveRules() {
        return Stream.of(
                new RandomlyMoveRule(() -> 3),
                new RandomlyMoveRule(() -> 2),
                new RandomlyMoveRule(() -> 1),
                new RandomlyMoveRule(() -> 0));
    }
}
