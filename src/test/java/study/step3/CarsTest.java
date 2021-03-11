package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("차량 3대 등록")
    @ParameterizedTest
    @CsvSource(value = {"3:3"}, delimiter = ':')
    void of(int carNumber, int expected) {
        Cars cars = Cars.of(carNumber);
        assertThat(cars.getSize()).isEqualTo(expected);
    }

    @DisplayName("차량 이동 정합성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:1:-,-,-", "4:2:--,--,--,--", "5:3:---,---,---,---,---"}, delimiter = ':')
    void move(int carNumber, int moveIndex, String expected) {
        MoveBehavior moveBehavior = new OneLocationMoveBehavior();
        Cars cars = Cars.of(carNumber);

        while (moveIndex-- > 0) {
            cars.move(moveBehavior);
        }

        assertThat(cars.stream()
                .map(car -> StringUtils.convertIntegerToStringDash(car.getLocation()))
                .collect(Collectors.joining(","))).isEqualTo(expected);
    }
}
