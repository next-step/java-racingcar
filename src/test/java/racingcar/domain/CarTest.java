package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CarTest {
    static Stream<String> invalidCarNames() {
        return Stream.of("", "OVER_FIVE_LENGTH");
    }

    @DisplayName("유효한 자동차 이름 검사")
    @Test
    void testValidCarName() {
        assertDoesNotThrow(() -> new Car("holee"));
    }

    @DisplayName("유효하지 않는 자동차 이름 검사")
    @ParameterizedTest
    @MethodSource("invalidCarNames")
    void testInvalidCarName(String carName) {
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("처음 자동차가 3칸 움직일 때, 자동차 거리가 0에서 3 증가한다.")
    @Test
    void testCarDistancePrintingValid() {
        List<Boolean> aMoves = Arrays.asList(true, false, true, false, true);
        Car a = new Car("A");

        carMove(a, aMoves);

        assertThat(a.getDistance())
            .isEqualTo(3);
    }

    private void carMove(Car car, List<Boolean> moves) {
        for (boolean carMoved: moves) {
            car.run(() -> carMoved);
        }
    }
}
