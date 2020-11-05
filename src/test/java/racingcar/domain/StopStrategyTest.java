package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StopStrategyTest {
    private StopStrategy stopStrategy = new StopStrategy();

    @Test
    void getMovingDistanceTest(){
        assertThat(stopStrategy.getMovingDistance()).isEqualTo(0);
    }
}
