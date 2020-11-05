package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ForwardStrategyTest {
    private ForwardStrategy forwardStrategy = new ForwardStrategy();

    @Test
    @DisplayName("ForwardStrategy의 getMovingDistance() 메서드 테스트. 기댓값: 1")
    void getMovingDistanceTest(){
        assertThat(forwardStrategy.getMovingDistance()).isEqualTo(1);
    }
}
