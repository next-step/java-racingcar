package racing.application;

import org.junit.Test;
import racing.infrastructure.CarMoveValidation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTest {
    Car mock = mock(Car.class);
    Car car = new Car();
    Validation validation = new CarMoveValidation();

    @Test
    public void 한칸이동() {
        //given
        when(mock.canMove(validation)).thenReturn(true);

        //when
        boolean movable = mock.canMove(validation);
        int actual = car.move(movable);

        //then
        assertThat(actual).isEqualTo(2);
    }
}