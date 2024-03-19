package racing;

import exception.CarLocationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.RacingValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {

    @Test
    @DisplayName("자동차가 1칸 앞으로 전진한다.")
    void 자동차_전진_테스트() throws CarLocationException {
        Car car = new Car(new Location(0));
        Location newLocation = car.getCarLocationInfo().moveForward();
        assertThat(newLocation.getLocation()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상의 숫자는 전진할 수 있음을 확인한다.")
    void 전진_가능_테스트(int input) {
        assertThat(RacingValidator.isMovable(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4미만의 숫자는 전진할 수 없음을 확인한다.")
    void 전진_불가능_테스트(int input) {
        assertThat(RacingValidator.isMovable(input)).isFalse();
    }

}
