package racingcar.strategy.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomBoundMovingStrategyTests {
    @DisplayName("전략 RandomBoundMoving 전략 일 때 move 시 1만큼의 거리를 움직이는 지 테스트")
    @Test
    void movingStrategyTest() {
        RandomBoundMovingStrategy randomBoundMovingStrategy = new RandomBoundMovingStrategy();

        int actual = randomBoundMovingStrategy.move();

        assertThat(actual).isEqualTo(1);
    }

}
