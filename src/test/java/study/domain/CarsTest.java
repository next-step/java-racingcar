package study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static study.calculator.Common.toInt;

class CarsTest {
    @ParameterizedTest
    @CsvSource({"1,0","1,0","1,0"})
    void 입력값만큼차량생성(String input, String expected) {
        Cars cars = new Cars(toInt(input));

        assertThat(cars.getCars()).extracting(car -> car.getDistance().getMove()).containsExactly(toInt(expected));
    }

    @DisplayName("N개의 자동차를 랜덤한 거리만큼 각각 이동하게하여 생성 테스트.")
    @ParameterizedTest
    @ValueSource(ints = {10})
    void 랜덤거리주행자동차여러개생성(int count) {
        Cars cars = new Cars(count);
        assertThat(cars.getCars().size()).isEqualTo(10);
    }

}