package carracing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import carracing.exception.ArgumentOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"dong,hyo,kim:3"}, delimiter = ':')
    @DisplayName("입력 수 만큼 자동차 수 생성 확인")
    void inputEqualsSize(String name, Integer size) {
        Cars cars = Cars.from(name);
        assertThat(cars.getSize()).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(strings = {"dong,hyohyo,kim", "dongdong,hyo,kim"})
    @DisplayName("이름 길이 초과 시 예외처리")
    void nameRangeException(String name) {
        assertThatExceptionOfType(ArgumentOutOfRangeException.class)
            .isThrownBy(() -> Cars.from(name));
    }

}
