package study.step3;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DriverRecruiterTest {

    CarManager carManager = new CarManager();
    DriverRecruiter driverRecruiter = new DriverRecruiter();

    @ParameterizedTest(name = "입력한 수 만큼 Driver 를 모집 | {arguments}")
    @CsvSource(value = {"3:3", "5:5"}, delimiter = ':')
    public void recruitDriver(int carNumber, int expected) {
        // given

        // when
        List<Car> cars = carManager.getCars(carNumber);
        List<Driver> drivers = driverRecruiter.recruit(cars);

        // then
        assertThat(drivers)
                .doesNotContainNull()
                .hasSize(expected);
    }

    @Test
    @DisplayName("입력되는 자동차 리스트가 null 인 경우 | {arguments}")
    public void nullInput() {
        // given
        List<Car> cars = null;

        // when
        ThrowingCallable throwingCallable = () -> driverRecruiter.recruit(cars);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(driverRecruiter.NOT_NULL);
    }
}
