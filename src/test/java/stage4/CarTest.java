package stage4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import stage4.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest {

    private String carName = "name";

    @Test
    @DisplayName("tryForward - 자동차 멈춤 테스트")
    void tryStopTest() {
        // given
        final int currentStatus = 0;
        final int impossible = 3;
        final int expectedStatus = 0;
        Car car = new Car(carName, currentStatus);

        // when
        final int result = car.tryForward(impossible);

        // then
        assertThat(expectedStatus).isEqualTo(result);
    }

    @Test
    @DisplayName("tryForward - 자동차 전진 테스트")
    void tryForwardTest() {
        // given
        final int currentStatus = 0;
        final int possible = 4;
        final int expectedStatus = 1;
        Car car = new Car(carName, currentStatus);

        // when
        final int result = car.tryForward(possible);

        // then
        assertThat(expectedStatus).isEqualTo(result);
    }
}
