package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StopStrategyGeneratorTest {
    private StopStrategyGenerator stopStrategyGenerator= new StopStrategyGenerator();

    @Test
    @DisplayName("StopStrategyGenerator의 generate() 메서드 테스트. 기댓값:StopStrategy.class")
    void generateTest(){
        assertThat(stopStrategyGenerator.generate()).isExactlyInstanceOf(StopStrategy.class);
    }
}
