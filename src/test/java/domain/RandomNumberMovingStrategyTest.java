package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RandomNumberMovingStrategyTest {

    MovingStrategy movableConditionTrue = () -> true;
    MovingStrategy movableConditionFalse = () -> false;

    @Test
    @DisplayName("움직일 수 있다면 true 를 리턴한다")
    void isMovable() {
        Assertions.assertThat(movableConditionTrue.isMovable()).isTrue();
    }

    @Test
    @DisplayName("움직일 수 있다면 false 를 리턴한다")
    void isNotMovable() {
        Assertions.assertThat(movableConditionFalse.isMovable()).isFalse();
    }
}