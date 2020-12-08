package step5.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.RandomGenerator;
import step5.domain.strategy.RandomMovingStrategy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RandomMovingStrategyTest {

    private RandomGenerator randomGenerator;
    private RandomMovingStrategy randomMovingStrategy;

    @BeforeEach
    void setUp() {
        randomGenerator = mock(RandomGenerator.class);
        randomMovingStrategy = new RandomMovingStrategy(randomGenerator);
    }

    @Test
    @DisplayName("랜덤값이 4이상이면 True 테스트")
    public void move() {
        when(randomGenerator.generate()).thenReturn(4);
        assertTrue(randomMovingStrategy.isMove());
    }

    @Test
    @DisplayName("랜덤값이 4미만이면 False 테스트")
    public void stop() {
        when(randomGenerator.generate()).thenReturn(3);
        assertFalse(randomMovingStrategy.isMove());
    }

}