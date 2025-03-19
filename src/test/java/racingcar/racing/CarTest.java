package racingcar.racing;

import org.junit.jupiter.api.Test;
import racingcar.movepolicy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {

    private Car car;
    private MoveStrategy moveStrategy;

    @Test
    void Car_객체를_생성한다() {
        moveStrategy = mock(MoveStrategy.class);
        car = new Car("pobi", moveStrategy);

        assertThat(car).isNotNull();
    }

    @Test
    void Car_객체를_생성할_때_이름이_5자_이하가_아니면_예외가_발생한다() {
        moveStrategy = mock(MoveStrategy.class);

        assertThrows(IllegalArgumentException.class, () -> new Car("pobicon", moveStrategy));
    }

    @Test
    void getName_호출시_이름을_반환한다() {
        moveStrategy = mock(MoveStrategy.class);
        car = new Car("pobi", moveStrategy);

        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void play_호출시_move가_true면_distance가_증가한다() {
        moveStrategy = mock(MoveStrategy.class);
        car = new Car("pobi", moveStrategy);

        when(moveStrategy.move()).thenReturn(true);

        car.play();

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void play_호출시_move가_false면_distance가_증가하지_않는다() {
        moveStrategy = mock(MoveStrategy.class);
        car = new Car("pobi", moveStrategy);

        when(moveStrategy.move()).thenReturn(false);

        car.play();

        assertThat(car.getDistance()).isEqualTo(0);
    }
}