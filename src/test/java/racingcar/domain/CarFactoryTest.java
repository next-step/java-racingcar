package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @DisplayName("null 또는 empty 또는 공백인 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void makeCars_ThrowsIllegalArgumentException_IfCarNamesIsNullOrEmptyOrBlank(String carNames) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> CarFactory.makeCars(carNames));
    }

    @DisplayName("생성")
    @Test
    void makeCars() {
        List<Car> cars = CarFactory.makeCars("benz,bmw,audi");
        assertThat(cars).hasSize(3);
        assertThat(cars).containsOnly(new Car("benz"), new Car("bmw"), new Car("audi"));
    }
}
