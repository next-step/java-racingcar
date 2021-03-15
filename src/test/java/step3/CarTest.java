package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.MoveStrategy;
import step3.domain.RandomMoveStrategy;
import step3.util.CarConstant;

public class CarTest {

    private final MoveStrategy mockStrategy = mock(RandomMoveStrategy.class);

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("pobi", CarConstant.INIT_POSITION);
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void move() {
        when(mockStrategy.isMove()).thenReturn(true);
        car.move(mockStrategy);
        assertEquals(2, car.getPosition());
    }
}
