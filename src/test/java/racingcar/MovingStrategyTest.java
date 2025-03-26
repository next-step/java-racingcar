package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovingStrategyTest {

    @Test
    @DisplayName("제공된 숫자가 4 이상이면 True를 Return한다.")
    void movingTest() {
        MovingStrategy movingStrategy = new MovingStrategy();
        assertThat(movingStrategy.isMoving(4)).isTrue();
    }

    @Test
    @DisplayName("제공된 숫자가 3 이하이면 False를 Return한다.")
    void notMovingTest() {
        MovingStrategy movingStrategy = new MovingStrategy();
        assertThat(movingStrategy.isMoving(3)).isFalse();
    }

    @Test
    @DisplayName("움직일 수 있는 숫자를 판단하는 임계값은 생성자로 조절할 수 있다.")
    void thresholdTest() {
        MovingStrategy movingStrategy = new MovingStrategy(6);
        assertThat(movingStrategy.isMoving(6)).isTrue();
        assertThat(movingStrategy.isMoving(5)).isFalse();
    }

    @Test
    @DisplayName("제공된 숫자가 0이상 9이하 이외의 수는 예외를 발생한다.")
    void exceptionTest() {
        MovingStrategy movingStrategy = new MovingStrategy();
        assertThrows(IllegalArgumentException.class, () -> movingStrategy.isMoving(-1));
        assertThrows(IllegalArgumentException.class, () -> movingStrategy.isMoving(10));
    }

    @Test
    @DisplayName("임계값으로 제공된 숫자가 0이상 9이하 이외의 수는 예외를 발생한다.")
    void constructorExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new MovingStrategy(-1));
        assertThrows(IllegalArgumentException.class, () -> new MovingStrategy(10));
    }


}
