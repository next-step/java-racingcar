package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final int DEFAULT_CAR_POSITION = 0;
    private static final int RANDOM_NUMBER_TO_MOVE = 5;

    @DisplayName("이동한 후 자동차의 위치가 1 증가한다")
    @Test
    void carMoveTest() {
        Car car = new Car(DEFAULT_CAR_POSITION);

        car.move(RANDOM_NUMBER_TO_MOVE);
        assertThat(car.getPosition()).isEqualTo(DEFAULT_CAR_POSITION + 1);
    }
}
