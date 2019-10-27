package racing;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.movestrategies.RandomMoveStrategy;

class CarTest {

    private Car car;
    private RandomMoveStrategy randomMoveStrategy;

    @BeforeEach
    void setUp() {
        randomMoveStrategy = mock(RandomMoveStrategy.class);
        car = new Car(randomMoveStrategy);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void 이동성공테스트(int tries) {
        when(randomMoveStrategy.canIMove())
            .thenReturn(true);

        IntStream.range(0, tries)
            .forEach(i -> car.move());

        assertThat(car.getPosition()).isEqualTo(tries);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void 이동실패테스트(int tries) {
        when(randomMoveStrategy.canIMove())
            .thenReturn(false);

        IntStream.range(0, tries)
            .forEach(i -> car.move());

        assertThat(car.getPosition()).isEqualTo(0);

    }
}