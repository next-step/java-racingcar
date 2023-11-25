package camp.nextstep.edu.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = { "a", "aa", "aaa", "aaaa", "aaaaa" })
    @DisplayName("차의 이름이 1~5자라면 잘 만들어진다")
    void carName(String input) {
        assertThatNoException()
            .isThrownBy(() -> new Car(input, () -> true));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "aaaaaa" })
    @DisplayName("차의 이름이 1~5자가 아니라면 예외가 발생한다")
    void carNameException(String input) {
        assertThatThrownBy(() -> new Car("", () -> true))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
