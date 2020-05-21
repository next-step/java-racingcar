package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CarTest {

    @DisplayName("자동차는 MovePolicy의 isMovable을 호출한다.")
    @Test
    public void verify_callMovePolicy_shouldSucceed() {
        MovePolicy movePolicy = mock(MovePolicy.class);
        Car car = new Car(new CarName(""), 0, movePolicy);
        car.move();
        verify(movePolicy).isMovable();
    }

    @DisplayName("자동차는 1칸씩 움직인다.")
    @ParameterizedTest()
    @CsvSource(value = {"0:1:1", "1:2:3", "2:3:5"}, delimiter = ':')
    public void verify_move_shouldSucceed(int initPosition, int round, int expected) {
        MovePolicy movePolicy = mock(MovePolicy.class);
        when(movePolicy.isMovable()).thenReturn(true);

        Car car = new Car(new CarName(""), initPosition, movePolicy);
        for (int i = 0; i < round; i++) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("자동차가 정지하면 위치의 변화가 없다.")
    @ParameterizedTest()
    @CsvSource(value = {"0:1:0", "1:2:1", "2:3:2"}, delimiter = ':')
    public void verify_stop_shouldSucceed(int initPosition, int round, int expected) {
        MovePolicy movePolicy = mock(MovePolicy.class);
        when(movePolicy.isMovable()).thenReturn(false);

        Car car = new Car(new CarName(""), initPosition, movePolicy);
        for (int i = 0; i < round; i++) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(expected);
    }

}
