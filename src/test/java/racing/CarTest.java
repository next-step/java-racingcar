package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {

    @Test
    @DisplayName("차가 움직였을때 위치 확인")
    void moveTest() {
        RandomMovement randomMovement = mock(RandomMovement.class);
        when(randomMovement.run()).thenReturn(true);
        Car car = new Car(randomMovement);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차가 움직이지 않았을때 위치 확인")
    void notMoveTest() {
        RandomMovement randomMovement = mock(RandomMovement.class);
        when(randomMovement.run()).thenReturn(false);
        Car car = new Car(randomMovement);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Car 객체 생성 테스트")
    void validation(CarMovement carMovement) {
        assertThatThrownBy(() -> new Car(carMovement))
                .isInstanceOf(IllegalArgumentException.class);
    }
}