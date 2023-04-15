package study.carrace.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomMoveStrategyTest {
    @Test
    @DisplayName("랜덤하게 생성된 값이 기준치 이상일 경우, moveOrStop() 메소드의 반환 값은 true")
    void move() {
        // given
        RandomMoveStrategy randomMoveStrategy = mockRandomMoveStrategy(mockRandomIntegerGenerator(1), 0);

        // when, then
        assertThat(randomMoveStrategy.moveOrStop()).isTrue();
    }

    @Test
    @DisplayName("랜덤하게 생성된 값이 기준치 미만일 경우, moveOrStop() 메소드의 반환 값은 false")
    void stop() {
        // given
        RandomMoveStrategy randomMoveStrategy = mockRandomMoveStrategy(mockRandomIntegerGenerator(0), 1);

        // when, then
        assertThat(randomMoveStrategy.moveOrStop()).isFalse();
    }

    private RandomIntegerGenerator mockRandomIntegerGenerator(int generated) {
        return () -> generated;
    }

    private RandomMoveStrategy mockRandomMoveStrategy(RandomIntegerGenerator randomIntegerGenerator,
                                                      int movableThreshold) {
        return new RandomMoveStrategy(randomIntegerGenerator, movableThreshold);
    }
}