package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DistanceTest {
    private static final String ERROR_TEST_CAR_NAME = "testtest";
    private static final int ERROR_TEST_CAR_DISTANCE = -1;

    @Test
    @DisplayName("자동차 초기화 거리가 음수이면 생성 안되는 테스트")
    public void testErrorCarDistance() {
        assertThatThrownBy(() -> new Car(ERROR_TEST_CAR_NAME, ERROR_TEST_CAR_DISTANCE))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
