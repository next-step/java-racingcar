package camp.nextstep.edu.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.racingcar.domain.Car;
import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("전략 객체를 실행한 값이 true라면 전진한다")
    void mustDrive() {
        // given
        DriveStrategy driveStrategy = () -> true;
        Car car = new Car(driveStrategy);

        // when
        DriveResult driveResult1 = car.drive();
        DriveResult driveResult2 = car.drive();

        // then
        assertThat(driveResult1.drivenDistance()).isEqualTo(1);
        assertThat(driveResult2.drivenDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("전략 객체를 실행한 값이 false라면 전진하지 않는다")
    void mustNotDrive() {
        // given
        DriveStrategy driveStrategy = () -> false;
        Car car = new Car(driveStrategy);

        // when
        DriveResult driveResult1 = car.drive();
        DriveResult driveResult2 = car.drive();

        // then
        assertThat(driveResult1.toString()).isEqualTo("");
        assertThat(driveResult2.toString()).isEqualTo("");
    }
}
