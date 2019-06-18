package study.racingcar.condition;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-18
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class ManualDeclarationCarMoveConditionTest {
    @Test
    void canMove() {
        assertThat(new ManualDeclarationCarMoveCondition(true).canMove()).isTrue();
    }
}