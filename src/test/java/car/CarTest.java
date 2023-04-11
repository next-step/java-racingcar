package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("랜덤값이 4 이상일 경우 자동차가 이동한다")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void carRandomMoveTest(int input) {
        Car car = new Car(DEFAULT_CAR_POSITION);

        car.move(input);
        assertThat(car.getPosition()).isEqualTo(DEFAULT_CAR_POSITION + 1);
    }

    @DisplayName("랜덤값이 4 미만일 경우 자동차가 이동하지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void carRandomNotMoveTest(int input) {
        Car car = new Car(DEFAULT_CAR_POSITION);

        car.move(input);
        assertThat(car.getPosition()).isEqualTo(DEFAULT_CAR_POSITION);
    }
}
