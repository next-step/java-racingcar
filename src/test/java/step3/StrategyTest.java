package step3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;
import step3.domain.MoveStrategy;
import step3.domain.RandomMoveStrategy;
import step3.util.CarConstant;
import step3.util.RandomUtil;

public class StrategyTest {

    private final Random random = mock(Random.class);
    private MoveStrategy randomMoveStrategy;

    @BeforeEach
    void setUp() {
        this.randomMoveStrategy = new RandomMoveStrategy(RandomUtil.BOUND10, CarConstant.MOVE_CRITERIA);
    }

    @DisplayName("random 값이 4 이상일 경우만 전진")
    @Test
    void go() {
        when(random.nextInt(10)).thenReturn(4);
        Whitebox.setInternalState(RandomUtil.class, random);

        boolean move = randomMoveStrategy.isMove();
        assertTrue(move);

        verify(random).nextInt(10);
    }

    @DisplayName("random 값이 3 이하일 경우 멈춤")
    @Test
    void stop() {
        when(random.nextInt(10)).thenReturn(3);
        Whitebox.setInternalState(RandomUtil.class, random);

        boolean move = randomMoveStrategy.isMove();
        assertFalse(move);

        verify(random).nextInt(10);
    }
}
