package step3.application.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.application.domain.model.dto.MovementLog;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CarTest {


    public static Stream<Arguments> carTestDataSet() {
        return Stream.of(
                arguments(new Car("pobi", 1), false, new MovementLog("pobi", 1)),
                arguments(new Car("crong", 1), true, new MovementLog("crong", 2)),
                arguments(new Car("honux", 2), true, new MovementLog("honux", 3))
        );
    }

    @ParameterizedTest
    @MethodSource("carTestDataSet")
    @DisplayName("움직임 여부에 따라 현재 위치를 유지하거나 변경한다.")
    void 움직임을_시도한다(Car car, boolean movables, MovementLog expectedPosition) {
        MovementLog log = car.move(movables);
        assertThat(log).isEqualTo(expectedPosition);
    }
}