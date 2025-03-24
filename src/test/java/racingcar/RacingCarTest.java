package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.policy.CarImmovablePolicy;
import racingcar.policy.CarMovabilityPolicy;
import racingcar.utils.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void 자동차_생성() {
        Car car = Car.create("one");
        assertThat(car).isInstanceOf(Car.class);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_생성_실패() {
        assertThatThrownBy(() -> Car.create(",123456"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"one,two,three,four,five:5"}, delimiter = ':')
    void 자동차_여러_대_생성(String value, int count) {
        Cars cars = Cars.create(StringUtils.splitByComma(value));
        assertThat(cars.getValues()).hasSize(count);
        assertThat(cars.getPositions()).hasSize(count);
        assertThat(cars.getPositions()).allMatch(position -> position.equals(1));
    }

    @Test
    void 자동차_전진() {
        Car car = Car.create("one");
        Car moved = car.move(new CarMovabilityPolicy());
        assertThat(moved.getPosition()).isEqualTo(2);
    }

    @Test
    void 자동차_정지() {
        Car car = Car.create("one");
        car.move(new CarImmovablePolicy());
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
