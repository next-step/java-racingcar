import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarTest {
    @Mock
    MovePolicy movePolicy = mock(MovePolicy.class);

    @InjectMocks
    Car car;

    @Test
    public void 자동차_전진여부논리값이true라면위치는변한다() {
        when(movePolicy.isAbleToMove()).thenReturn(true);

        int beforePosition = car.getPosition();
        car.move();
        int afterPosition = car.getPosition();

        assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

    @Test
    public void 자동차_전진여부논리값이false라면위치는변하지않는다() {
        when(movePolicy.isAbleToMove()).thenReturn(false);

        int beforePosition = car.getPosition();
        car.move();
        int afterPosition = car.getPosition();

        assertThat(beforePosition).isEqualTo(afterPosition);
    }
}