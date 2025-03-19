package racingcar.car;

import org.junit.jupiter.api.Test;
import racingcar.movepolicy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {

    private Car car;
    private MoveStrategy moveStrategy;

    @Test
    void play_호출시_move가_true면_distance가_증가한다() {
        moveStrategy = mock(MoveStrategy.class);
        car = new Car(moveStrategy);

        when(moveStrategy.move()).thenReturn(true);

        car.play();

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void play_호출시_move가_false면_distance가_증가하지_않는다() {
        moveStrategy = mock(MoveStrategy.class);
        car = new Car(moveStrategy);

        when(moveStrategy.move()).thenReturn(false);

        car.play();

        assertThat(car.getDistance()).isEqualTo(0);
    }
}