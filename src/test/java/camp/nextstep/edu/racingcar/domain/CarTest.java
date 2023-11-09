package camp.nextstep.edu.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        Car car = new Car("name", driveStrategy);

        // when
        DriveResult driveResult1 = car.drive();
        DriveResult driveResult2 = car.drive();

        // then
        assertThat(driveResult1.drivenDistance).isEqualTo(1);
        assertThat(driveResult2.drivenDistance).isEqualTo(2);
    }

    @Test
    @DisplayName("전략 객체를 실행한 값이 false라면 전진하지 않는다")
    void mustNotDrive() {
        // given
        DriveStrategy driveStrategy = () -> false;
        Car car = new Car("name", driveStrategy);

        // when
        DriveResult driveResult1 = car.drive();
        DriveResult driveResult2 = car.drive();

        // then
        assertThat(driveResult1.drivenDistance).isEqualTo(0);
        assertThat(driveResult2.drivenDistance).isEqualTo(0);
    }

    @Test
    @DisplayName("차의 이름은 공백 제외 1~5자여야 한다")
    void carName() {
        DriveStrategy driveStrategy = () -> true;

        assertThatThrownBy(() -> new Car("", driveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("  ", driveStrategy))
            .isInstanceOf(IllegalArgumentException.class);

        Car lengthOne = new Car("a", driveStrategy);
        assertThat(lengthOne.name()).hasSize(1);
        Car lengthFive = new Car("aaaaa", driveStrategy);
        assertThat(lengthFive.name()).hasSize(5);

        assertThatThrownBy(() -> new Car("aaaaaa", driveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
