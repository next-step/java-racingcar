package study.step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverTest {

    @ParameterizedTest(name = "랜덤 주행하면 가만히 있거나 전진하는지 확인 | {arguments}")
    @CsvSource(value = {"0:0:1", "0:0:1", "0:0:1", "0:0:1"}, delimiter = ':')
    public void drive(int startPosition, int expectedNotMove, int expectedMoveForward) {
        // given
        Car car = new Car(startPosition);
        Driver driver = new Driver(car);

        // when
        driver.drive();

        // then
        assertThat(car.getPosition())
                .isGreaterThanOrEqualTo(expectedNotMove)
                .isLessThanOrEqualTo(expectedMoveForward);
    }
}
