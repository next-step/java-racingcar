package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 - CarName 테스트")
public class CarNameTest {
    public static final String VALID_CAR_NAME = "왕민";
    private static final String OVERSIZE_CAR_NAME = "wangmin";

    @ParameterizedTest
    @ValueSource(strings = {OVERSIZE_CAR_NAME, " ", ""})
    void CarName은_올바르지_않을경우_런타임_예외를_발생_시킨다(String name) {
        assertThatThrownBy(() -> {
            new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
