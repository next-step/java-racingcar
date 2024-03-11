package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.fixture.DrivingStrategyFixture.ALWAYS_MOVE;
import static racingcar.fixture.DrivingStrategyFixture.NEVER_MOVE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.fixture.CarFixture;

public class CarTest {

    private final Car car = CarFixture.car();

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() {
        car.drive(ALWAYS_MOVE);
        assertThat(car.drivingDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() {
        car.drive(NEVER_MOVE);
        assertThat(car.drivingDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void result() {
        car.drive(ALWAYS_MOVE);
        assertThat(car.result()).isEqualTo(car.name() + " : -");
        car.drive(ALWAYS_MOVE);
        assertThat(car.result()).isEqualTo(car.name() + " : --");
    }
}
