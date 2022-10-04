package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingConditionTest {

    @ParameterizedTest
    @ValueSource(ints = {-1})
    void racingCondition_잘못된_자동차대수에대해서_예외가발생한다(int invalidCarCount) {
        Assertions.assertThatThrownBy(() -> {
            new RacingCondition(invalidCarCount, 1);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1})
    void racingCondition_잘못된_시도할회수에대해서_예외가발생한다(int invalidAttemptCount) {
        Assertions.assertThatThrownBy(() -> {
            new RacingCondition(1, invalidAttemptCount);
        }).isInstanceOf(RuntimeException.class);
    }
}
