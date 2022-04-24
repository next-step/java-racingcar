package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 - CarName 테스트")
public class CarNameTest {
    private static final String OVERSIZE_CAR_NAME = "wangmin";
    private static final String VALID_CAR_NAME = "왕민";
    public static final CarName validCarName = new CarName(VALID_CAR_NAME);

    private static Stream<String> invalidStrings() {
        return Stream.of(OVERSIZE_CAR_NAME, " ", "", null);
    }

    @Test
    void CarName은_이름으로_생성이_가능하다() {
        assertThat(new CarName(validCarName.getName())).isEqualTo(validCarName);
    }

    @ParameterizedTest
    @MethodSource("invalidStrings")
    void CarName은_올바르지_않을경우_런타임_예외를_발생_시킨다(String name) {
        assertThatThrownBy(() -> {
            new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
