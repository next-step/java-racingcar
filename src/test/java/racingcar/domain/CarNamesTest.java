package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.exception.InvalidCarNameException;

class CarNamesTest {
    @DisplayName("자동차 이름 길이가 유효하다면 자동차 이름 객체를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = { "pobby,crong, honux=3" }, delimiter = '=')
    void of(String carNames, int expectCarCount) {
        CarNames names = CarNames.of(carNames);
        
        assertThat(names).isNotNull().isInstanceOf(CarNames.class);    
        assertThat(names.carCount()).isEqualTo(expectCarCount);
    }
    
    @DisplayName("자동차 이름 길이가 유효하지 않다면 InvalidCarNameException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = { "", "pobi, honux,invalid"})
    void of_invalid_car_name(String invalidCarNames) {
        assertThatThrownBy(() -> {
            CarNames.of(invalidCarNames);
        }).isInstanceOf(InvalidCarNameException.class)
          .hasMessageMatching("The car name is at least 1 characters and up to 5 characters.");
    }
}
