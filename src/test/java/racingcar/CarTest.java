package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import racingcar.domain.Car;
import racingcar.domain.MoveType;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @DisplayName("차량 정지 및 전진 테스트")
    @EnumSource(value = MoveType.class)
    void testMoveCar(MoveType moveType) {
        Car car = new Car();
        car.move(moveType);

        assertThat(car.position()).isEqualTo(moveType.movePosition());
    }

}
