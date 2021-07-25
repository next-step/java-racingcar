package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MovingStrategyFactoryTest {

    @DisplayName("getRandomStrategy()함수를 호출하면 RandomMovingStrategy를 반환해야한다 ")
    @Test
    public void should_return_RandomMovingStrategy() throws Exception {
        //arrange
        MovingStrategy strategy = MovingStrategyFactory.getRandomStrategy();

        //act, assert
        assertThat(strategy).isInstanceOf(RandomMovingStrategy.class);
    }

}