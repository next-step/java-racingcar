package study.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {
    @ParameterizedTest
    @CsvSource({"1,1","2,2","3,3"})
    void 입력값만큼차량생성(int input, int expected) {
        Cars cars = new Cars(input);
        assertThat(cars.getCars().size()).isEqualTo(expected);
    }

    @DisplayName("N개의 자동차를 랜덤한 거리만큼 각각 이동하게하여 생성 테스트.")
    @ParameterizedTest
    @ValueSource(ints = {10})
    void 랜덤거리주행자동차여러개생성(int count) {
        Cars cars = new Cars(count);
        assertThat(cars.getCars().size()).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource({"2,2"})
    void 이름및수량만큼차량생성(int count, int expected) {
        String[] carName = {"test1","test2"};
        Cars cars = new Cars(count, carName);

        assertThat(cars.getCars().size()).isEqualTo(expected);
        assertThat(cars.getCars()).extracting(car -> car.getName().getCarName()).containsExactly(carName);
    }
}