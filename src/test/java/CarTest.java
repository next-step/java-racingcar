import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarTest {
    @Mock
    MovePolicy movePolicy = mock(MovePolicy.class);

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @Test
    public void 자동차_전진여부논리값이true라면위치는변한다() {
        when(movePolicy.isAbleToMove()).thenReturn(true);

        int beforePosition = car.getPosition();
        car.move(movePolicy);
        int afterPosition = car.getPosition();

        assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

    @Test
    public void 자동차_전진여부논리값이false라면위치는변하지않는다() {
        when(movePolicy.isAbleToMove()).thenReturn(false);

        int beforePosition = car.getPosition();
        car.move(movePolicy);
        int afterPosition = car.getPosition();

        assertThat(beforePosition).isEqualTo(afterPosition);
    }

    @Test
    public void 자동차이름은_5자를_초과할수없다() {
        String name = "abcdef";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }
}