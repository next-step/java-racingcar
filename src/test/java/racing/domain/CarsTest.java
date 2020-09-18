package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("입력한 값 만큼 자동차 생성 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e : 5",
            "aa,bbb,cccc,dddd, : 4"}, delimiter = ':')
    public void create(String carNames, int result) {
        Cars cars = new Cars(carNames);
        assertThat(cars.getCars()).hasSize(result);
    }
}