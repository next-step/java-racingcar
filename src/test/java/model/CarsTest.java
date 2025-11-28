package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class CarsTest {
    @DisplayName("자동차 이름으로 입력받았을 때 그 수만큼 자동차를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,houx: 3", "kim,lee: 2"}, delimiter = ':')
    public void CarsSetup(String carNames, int expected) {
        Cars cars = new Cars(carNames);

        assertThat(cars.getCarsCount()).isEqualTo(expected);
    }
}
