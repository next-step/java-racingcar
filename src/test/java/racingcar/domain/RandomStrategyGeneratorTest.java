package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyGeneratorTest {
    private RandomStrategyGenerator randomStrategyGenerator = new RandomStrategyGenerator();

    @Test
    @DisplayName("RandomStrategyGenerator의 generate() 메서드 테스트. 기댓값:MoveStrategy 타입의 클래스")
    void generateTest(){
        assertThat(randomStrategyGenerator.generate()).isInstanceOf(MoveStrategy.class);
    }
}
