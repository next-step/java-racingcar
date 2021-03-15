package study.step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step5.constant.RacingConstant;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("차량 5대 등록")
    @ParameterizedTest
    @CsvSource(value = {"자동차1호,자동차2호,자동차3호,자동차4호,자동차5:5"}, delimiter = ':')
    void of(String carNames, int expected) {
        Cars cars = Cars.of(carNames.split(RacingConstant.COMMA));
        assertThat(cars.getSize()).isEqualTo(expected);
    }
}
