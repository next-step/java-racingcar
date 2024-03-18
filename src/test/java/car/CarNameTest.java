package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    private static final String TEST_CAR_NAME = "test";
    private static final String ERROR_TEST_CAR_NAME = "testtest";

    @Test
    @DisplayName("자동차 이름이 정상적으로 할당되는지 테스트")
    public void testCarName() {
        CarName car = new CarName(TEST_CAR_NAME);
        assertThat(car.getName()).isEqualTo(TEST_CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름이 5자이상이면 생성 안되는 테스트")
    public void testErrorCarName() {
        assertThatThrownBy(() -> new CarName(ERROR_TEST_CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
