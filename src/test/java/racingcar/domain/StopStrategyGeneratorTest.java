package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StopStrategyGeneratorTest {
    private StopStrategyGenerator stopStrategyGenerator= new StopStrategyGenerator();

    @Test
    void generateTest(){
        assertThat(stopStrategyGenerator.generate()).isExactlyInstanceOf(StopStrategy.class);
    }
}
