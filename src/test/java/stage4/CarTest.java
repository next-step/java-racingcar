package stage4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import stage4.domain.Car;
import stage4.domain.CarName;
import stage4.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest {

    private String carName = "name";

    @Test
    @DisplayName("tryForward - 자동차 멈춤 테스트")
    void tryStopTest() {
        // given
        final Position currentPosition = new Position(0);
        final Position expectedStatus = new Position(0);
        Car car = new Car(new CarName(carName), currentPosition);

        // when
        final Position result = car.tryForward(() -> 3);

        // then
        assertThat(expectedStatus).isEqualTo(result);
    }

    @Test
    @DisplayName("tryForward - 자동차 전진 테스트")
    void tryForwardTest() {
        // given
        final Position currentPosition = new Position(0);
        final Position expectedStatus = new Position(1);
        Car car = new Car(new CarName(carName), currentPosition);

        // when
        final Position result = car.tryForward(() -> 4);

        // then
        assertThat(expectedStatus).isEqualTo(result);
    }
}
