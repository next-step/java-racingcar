package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(strings = {"porsche", " ", "      "})
    @EmptySource
    @DisplayName("입력된 차 이름이 5자 초과, 공백, empty 일 경우 IllegalArgumentException 발생")
    void case_when_create_carName_throws_illegalArgumentExcpetion(String carName) {
        assertThrows(IllegalArgumentException.class, () -> CarName.of(carName));
    }

    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(strings = {"benz", "audi", "bmw"})
    @DisplayName("입력된 차 이름이 5자 이하일 경우 성공")
    void case_when_carName_length_under_5(String carName) {
        CarName createdCarName = CarName.of(carName);
        assertThat(createdCarName.getName()).isEqualTo(carName);
    }
}
