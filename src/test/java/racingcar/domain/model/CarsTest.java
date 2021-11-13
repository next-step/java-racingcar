package racingcar.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.NameOutOfRangeException;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차 컬렉션 생성")
    @CsvSource(value = {"kim,dong,hyo:3", "dong,hyo:2", "hyo:1"}, delimiter = ':')
    void createCars(String name, long size) {
        assertThat(Cars.from(name).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 길이 초과 예외처리")
    @ValueSource(strings = "kim,dong,hyohyo")
    void createCarsException(String name) {
        assertThatExceptionOfType(NameOutOfRangeException.class)
            .isThrownBy(() -> Cars.from(name));
    }

}
