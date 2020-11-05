package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ForwardStrategyTest {
    private ForwardStrategy forwardStrategy = new ForwardStrategy();

    @Test
    void getMovingDistanceTest(){
        assertThat(forwardStrategy.getMovingDistance()).isEqualTo(1);

    }
}
