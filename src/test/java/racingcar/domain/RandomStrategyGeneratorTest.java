package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyGeneratorTest {
    private RandomStrategyGenerator randomStrategyGenerator = new RandomStrategyGenerator();

    @Test
    void generateTest(){
        assertThat(randomStrategyGenerator.generate()).isInstanceOf(MoveStrategy.class);
    }
}
