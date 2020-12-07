package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.NameFormatException;
import racing.exception.NameOutOfRangeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("자동차 이름(CarName) 테스트")
public class CarNameTest {

    @DisplayName("5자 이내의 이름을 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"쇼", "미더", "머니?", "산화머니", "자동차이름"})
    void create(String value) {
        // when
        CarName carName = CarName.of(value);

        // then
        assertThat(carName).isNotNull();
    }

    @DisplayName("null 값은 허용하지 않는다.")
    @Test
    void createNotNull() {
        // when / then
        assertThrows(NameFormatException.class, () -> CarName.of(null));
    }

    @DisplayName("빈 값은 허용하지 않는다.")
    @Test
    void createNotEmpty() {
        // when / then
        assertThrows(NameFormatException.class, () -> CarName.of(""));
    }

    @DisplayName("5자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"여섯글자이름", "일곱그을자이름"})
    void createLengthOver(String value) {
        // when / then
        assertThrows(NameOutOfRangeException.class, () -> CarName.of(value));
    }
}
