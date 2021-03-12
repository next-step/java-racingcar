package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("차량 5대 등록")
    @ParameterizedTest
    @CsvSource(value = {"자동차1호,자동차2호,자동차3호,자동차4호,자동차5:5"}, delimiter = ':')
    void of(String carNames, int expected) {
        Cars cars = Cars.of(carNames.split(RacingConstant.COMMA));
        assertThat(cars.getSize()).isEqualTo(expected);
    }

    @DisplayName("차량 이동 정합성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"자동차1호:1:-", "자동차1호,자동차2호:4:----,----", "자동차1호,자동차2호,자동차3호:5:-----,-----,-----"}, delimiter = ':')
    void move(String carNames, int moveIndex, String expected) {
        MoveBehavior moveBehavior = new OneLocationMoveBehavior();
        Cars cars = Cars.of(carNames.split(RacingConstant.COMMA));

        while (moveIndex-- > 0) {
            cars.move(moveBehavior);
        }

        assertThat(cars.stream()
                .map(car -> car.getLocationToString())
                .collect(Collectors.joining(RacingConstant.COMMA))).isEqualTo(expected);
    }
}
