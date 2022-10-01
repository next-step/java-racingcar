package step4.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("입력값에 대해서 쉼표 기준으로 자동차 리스트를 만들어야 한다.")
    @CsvSource(value = "'ho,hi,hu,li'")
    void initCarsTest(String nameInput) {
        Cars cars = new Cars();
        cars.init(nameInput);
        Assertions.assertThat(cars.getCars().size()).isEqualTo(4);
    }
}
