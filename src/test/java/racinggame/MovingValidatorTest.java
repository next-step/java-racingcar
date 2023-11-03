package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingValidatorTest {

    @ParameterizedTest(name = "random값이 {0}이면 false")
    @ValueSource(ints = {0, 1, 2, 3})
    void false_test(int input) {
        MovingValidator movingValidator = new MovingValidator(new TestMovingStrategy(input));
        boolean actual = movingValidator.movable();

        assertThat(actual).isFalse();
    }

    @ParameterizedTest(name = "random값이 {0}이면 true")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    void true_test(int input) {
        MovingValidator movingValidator = new MovingValidator(new TestMovingStrategy(input));
        boolean actual = movingValidator.movable();

        assertThat(actual).isTrue();
    }

}
