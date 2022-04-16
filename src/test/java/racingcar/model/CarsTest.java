package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 객체 생성 확인")
    void confirmCarObjectCreation() {
        Cars cars = new Cars(new RandomMovingStrategy(), new String[]{"pobi", "cron", "yuna"});

        assertThat(cars.getCars()).hasSize(3);
    }
}