package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.powermock.reflect.Whitebox;

public class CarTest {

    private final Random random = mock(Random.class);
    private Car car;
    private Limit limit;

    @BeforeEach
    void setUp() {
        this.car = new Car("pobi", CarConstant.INIT_POSITION);
        this.limit = new CarLimit();
        limit.setLimitStrategy(new Limit4Strategy());
    }

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true, 1", "false, 0"})
    void move(boolean isMove, int exp) {
        car.move(isMove);
        assertEquals(exp, car.getPosition());
    }

    @DisplayName("random 값이 4 이상일 경우만 전진")
    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"})
    void go(int input) {
        mockRandom(input);

        given(input, limit);

        assertEquals(1, car.getPosition());
        verify(random).nextInt(input);
    }

    @DisplayName("random 값이 4 미만일 경우 멈춤")
    @ParameterizedTest
    @CsvSource(value = {"0", "1", "2", "3"})
    void stop(int input) {
        mockRandom(input);

        given(input, limit);

        assertEquals(0, car.getPosition());
        verify(random).nextInt(input);
    }

    private void mockRandom(int input) {
        when(random.nextInt(anyInt())).thenReturn(input);
        Whitebox.setInternalState(RandomUtil.class, random);
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

    private void given(int input, Limit limit) {
        int randomValue = RandomUtil.nextInt(input);
        boolean move = car.isMove(randomValue, limit.getLimit());
        car.move(move);
    }

    private void givenCar(Cars cars, int max) {
        cars.addCar(new Car("max-2", max - 2));
        cars.addCar(new Car("max-1", max - 1));
        cars.addCar(new Car("max1", max));
        cars.addCar(new Car("max2", max));
    }
}
