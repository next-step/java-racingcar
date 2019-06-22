package racingcar.domain.moving;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultMovingStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8,9})
    @DisplayName("랜덤숫자가 4이상인경우 전진하는것을 확인한다")
    void testMovingForward(Integer num) {
        // given
        MovingStrategy movingStrategy = new DefaultMovingStrategy(new MockRandomValueProvider(num));
        // when
        boolean move = movingStrategy.movable();
        // then
        assertTrue(move);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    @DisplayName("랜덤숫자가 4보다 작거나 같은경우 전진하지 않는것을 확인한다")
    void testNotMovingForward(Integer num) {
        // given
        MovingStrategy movingStrategy = new DefaultMovingStrategy(new MockRandomValueProvider(num));
        // when
        boolean move = movingStrategy.movable();
        // then
        assertFalse(move);
    }
}
