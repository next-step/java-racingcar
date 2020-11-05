package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StopStrategyTest {
    private StopStrategy stopStrategy = new StopStrategy();

    @Test
    @DisplayName("StopStrategy의 getMovingDistance() 메서드 테스트. 기댓값: 0")
    void getMovingDistanceTest(){
        assertThat(stopStrategy.getMovingDistance()).isEqualTo(0);
    }
}
