package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SixtyPercentRandomMoveConditionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void movable(final int randomValue) {
        final RandomValueGenerator testRandomValueGenerator = (bound -> randomValue);
        final SixtyPercentRandomMoveCondition condition =
            new SixtyPercentRandomMoveCondition(testRandomValueGenerator);

        if (randomValue <= 3) {
            assertThat(condition.isMovable()).isFalse();
            return;
        }
        assertThat(condition.isMovable()).isTrue();
    }
}