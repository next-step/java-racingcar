package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.powermock.reflect.Whitebox;

public class CarTest {

    private final Random random = mock(Random.class);
    private final MoveStrategy mockStrategy = mock(RandomMoveStrategy.class);
    private final MoveStrategy strategy = new RandomMoveStrategy(RandomUtil.BOUND10, CarConstant.MOVE_CRITERIA);

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

    @DisplayName("random 값이 4 이상일 경우만 전진")
    @Test
    void go() {
        when(random.nextInt(10)).thenReturn(4);
        Whitebox.setInternalState(RandomUtil.class, random);

        boolean move = strategy.isMove();
        assertTrue(move);

        verify(random).nextInt(10);
    }

    @DisplayName("random 값이 3 이하일 경우 멈춤")
    @Test
    void stop() {
        when(random.nextInt(10)).thenReturn(3);
        Whitebox.setInternalState(RandomUtil.class, random);

        boolean move = strategy.isMove();
        assertFalse(move);

        verify(random).nextInt(10);
    }

    @DisplayName("제일 많이 가면 우승자")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4", "5"})
    void winners(int maxPosition) {
        Cars cars = new Cars();
        givenCar(cars, maxPosition);

        List<Car> winners = cars.getWinners();

        assertEquals(maxPosition, winners.get(0).getPosition());
    }

    private void givenCar(Cars cars, int max) {
        cars.addCar(new Car("max-2", max - 2));
        cars.addCar(new Car("max-1", max - 1));
        cars.addCar(new Car("max1", max));
        cars.addCar(new Car("max2", max));
    }
}
