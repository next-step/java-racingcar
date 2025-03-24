package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.policy.CarImmovablePolicy;
import racingcar.policy.CarMovabilityPolicy;
import racingcar.utils.StringUtils;
import racingcar.vo.CarPosition;

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

    @ParameterizedTest
    @CsvSource(value = {"one:4,two:3,three:2,four:1,five:4=one,five"}, delimiter = '=')
    void 자동차_우승자(String carData, String expectedWinners) {
        Cars cars = new Cars(
            StringUtils.splitByComma(carData)
                .stream()
                .map(data -> {
                    String[] parts = data.split(":");
                    return new Car(parts[0], new CarPosition(Integer.parseInt(parts[1])));
                })
                .collect(Collectors.toList())
        );

        List<String> expected = StringUtils.splitByComma(expectedWinners);
        assertThat(cars.getWinnerNames()).isEqualTo(expected);
    }
}
