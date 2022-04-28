package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 - CarName 테스트")
public class CarNameTest {
    private static final String OVERSIZE_NAME = "wangmin";
    private static final String VALID_NAME = "왕민";
    public static final CarName VALID_CAR_NAME = new CarName(VALID_NAME);
    private static final String WINNER_NAME = "win";
    static final CarName WINNER_CAR_NAME = new CarName(WINNER_NAME);

    private static Stream<String> invalidNames() {
        return Stream.of(OVERSIZE_NAME, " ", "", null);
    }

    @ParameterizedTest
    @MethodSource("invalidNames")
    void CarName은_올바르지_않을경우_런타임_예외를_발생_시킨다(String name) {
        assertThatThrownBy(() -> {
            new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
