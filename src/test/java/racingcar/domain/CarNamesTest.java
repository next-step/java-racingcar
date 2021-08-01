package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {

    @DisplayName("null 또는 empty 또는 공백인 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void create_ThrowsIllegalArgumentException_IfCarNamesIsNullOrEmptyOrBlank(String carNames) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new CarNames(carNames));
    }

    @DisplayName("생성")
    @Test
    void create() {
        CarNames carNames = new CarNames("benz,bmw,audi");
        assertThat(carNames.getCarNames()).containsExactly("benz", "bmw", "audi");
    }
}
