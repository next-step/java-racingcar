package study.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @DisplayName("입력 값만큼 자동차를 생성")
    @ValueSource(ints = {1,5,10,100})
    @ParameterizedTest
    void createCarList(int expected) {
        Cars cars = new Cars(expected);
        int count = cars.numberOfCar();
        Assertions.assertThat(count).isEqualTo(expected);
    }

}
