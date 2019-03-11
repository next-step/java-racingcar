package racing.application;

import org.junit.Test;
import racing.infrastructure.CarMoveValidation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTest {
    Validation mock = mock(CarMoveValidation.class);
    Car car = new Car();

    @Test
    public void 한칸이동() {
        //given
        when(mock.check()).thenReturn(true);

        //when
        int actual = car.move(mock.check());

        //then
        assertThat(actual).isEqualTo(2);
    }
}