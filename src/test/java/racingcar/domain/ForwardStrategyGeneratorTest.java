package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ForwardStrategyGeneratorTest {
    private ForwardStrategyGenerator forwardStrategyGenerator = new ForwardStrategyGenerator();

    @Test
    @DisplayName("ForwardStrategyGenerator의 generate() 메서드 테스트. 기댓값:ForwardStrategy.class")
    void generateTest(){
        assertThat(forwardStrategyGenerator.generate()).isExactlyInstanceOf(ForwardStrategy.class);
    }
}
