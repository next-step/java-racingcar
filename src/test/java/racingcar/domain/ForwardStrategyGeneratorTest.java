package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ForwardStrategyGeneratorTest {
    private ForwardStrategyGenerator forwardStrategyGenerator = new ForwardStrategyGenerator();

    @Test
    void generateTest(){
        assertThat(forwardStrategyGenerator.generate()).isExactlyInstanceOf(ForwardStrategy.class);
    }
}
