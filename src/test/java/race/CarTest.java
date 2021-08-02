package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    private static final String DEFAULT_NAMES = "pobi";
    private static final boolean FORWARD_MOVE = true;
    private static final boolean STOP_MOVE = false;
    private static final int FIRST_TRY = 1;

    private static final int FORWARD_DISTANCE = 1;
    private static final int STOP_DISTANCE = 0;

    @DisplayName("각 시도횟수만큼 이동거리값 반환")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2", "3:3", "4:4"}, delimiter = ':')
    void getDistance(int maxTryCount, int expected) {
        Car car = Car.of(DEFAULT_NAMES);
        for (int tryCount = 0; tryCount < maxTryCount; tryCount++) {
            car.move(FORWARD_MOVE);
        }
        assertThat(car.getDistance(maxTryCount)).isEqualTo(expected);
    }

    @DisplayName("시도할 회수만큼 자동차 이동(전진)되었는지 확인")
    @Test
    void move_forward() {
        Car car = Car.of(DEFAULT_NAMES);
        car.move(FORWARD_MOVE);

        assertThat(car.getDistance().get(FIRST_TRY)).isEqualTo(FORWARD_DISTANCE);
    }

    @DisplayName("시도할 회수만큼 자동차 이동(정지)되었는지 확인")
    @Test
    void move_stop() {
        Car car = Car.of(DEFAULT_NAMES);
        car.move(STOP_MOVE);
        assertThat(car.getDistance().get(FIRST_TRY)).isEqualTo(STOP_DISTANCE);
    }

}